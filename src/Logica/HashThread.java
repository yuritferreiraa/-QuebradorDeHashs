/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static Logica.ThreadManeger.ai;
import Utilidades.UtilThread;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author dogma
 */
public class HashThread extends Thread {
    private boolean ok=true;
    private long start = System.currentTimeMillis();
    private double elapsed;
    private int timeReal;
    private String time;
    private String hash[];
    private int threadDivisor;
    private int position;
    private int numTerms;
    private String senha;
    private byte messageDigest[] = null;
    private MessageDigest algorithm = null;
    private UtilThread ut;
    private String hashSenha;
    private char alfa[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'
            , 'l', 'm', 'n','o', 'p', 'q', 'r', 's', 't', 'u', 'w', 'v', 'x', 'y'
            , 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'
            , 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'W','V', 'X', 'Y', 'Z', '!'
            , '@', '#', '$', '%', '&', '*', '(', ')', '_', '-', '+', '=', '[', ']'
            , '{', '}', '?', '/', '\\', '|', '>', '<', '.', '0', '1', '2', '3', '4'
            , '5', '6', '7','8', '9'};
    FileWriter fw;
    
    public HashThread(String hash[], int numTerms, int numThreads, int positionThread) {
        this.hash=hash;
        this.threadDivisor=numThreads;
        this.position=positionThread;
        this.numTerms=numTerms;
        start = System.currentTimeMillis();
        ut = new UtilThread();
        fw = ut.arquivar(fw, positionThread);
    }
    
    @Override
    public void run() {
        switch(numTerms) {
            case 1:
                hash1Digitos();
                break;
            case 2:
                hash2Digitos();
                break;
            case 3:
                hash3Digitos();
                break;
            case 4:
                hash4Digitos();
                break;
            case 5:
                hash5Digitos();
                break;
            case 6:
                hash6Digitos();
                break;
            case 7:
                hash7Digitos();
                break;
            case 8:
                hash8Digitos();
                break;
        }
    }
    
    public void hash1Digitos() {
        block: while(!(this.getName().equals("find")) && !(this.getName().equals("end"))) {
            for (int i = 0+position; i < alfa.length; i+=threadDivisor) {
                if (this.getName().equals("find"))break block;
                    senha = ""+alfa[i];
                    hashSenha = ut.md5Decoder(senha);
                    for (int j = 0; j < hash.length; j++) {
                        if (hash[j].equals(hashSenha)) {
                            //this.setName("find");
                            System.out.println(senha + " - " + hash);
                            break block;
                    }
                }
                    
            }
            this.setName("end");
        }
    }
    
    public void hash2Digitos() {
        block: while(!(this.getName().equals("find")) && !(this.getName().equals("end"))) {
            for (int i = 0+position; i < alfa.length; i+=threadDivisor) {
                if (this.getName().equals("find"))break block;
                for (int j = 0; j < alfa.length; j++) {
                    senha = ""+alfa[i]+alfa[j];
                    hashSenha = ut.md5Decoder(senha);
                    for (int k = 0; k < hash.length; k++) {
                        if (hash.equals(hashSenha)) {
                        //this.setName("find");
                        //bw.append(senha + " - " + hash);
                        break block;
                    }
                    }
                }
            }
            this.setName("end");
        }
    }
    
    public void hash3Digitos() {
        block: while(!(this.getName().equals("find")) && !(this.getName().equals("end"))) {
            for (int i = 0+position; i < alfa.length; i+=threadDivisor) {
                for (int j = 0; j < alfa.length; j++) {
                    if (this.getName().equals("find")) break block;
                    for (int k = 0; k < alfa.length; k++) {
                        senha = ""+alfa[i]+alfa[j]+alfa[k];
                        hashSenha = ut.md5Decoder(senha);
                        for (int l = 0; l < hash.length; l++) {
                            if (hash[l].equals(hashSenha)) {
                            System.out.println(senha + " - " + hash[l]);
                            //this.setName("find");
                            //break block;
                        }
                        }
                    }
                }
            }
            this.setName("end");
        }
    }
    
    public void hash4Digitos() {
        block: while(!(this.getName().equals("find")) && !(this.getName().equals("end"))) {
            for (int i = 0+position; i < alfa.length; i+=threadDivisor) {
                for (int j = 0; j < alfa.length; j++) {
                    if (this.getName().equals("find"))break block;
                    for (int k = 0; k < alfa.length; k++) {
                        for (int l = 0; l < alfa.length; l++) {
                            senha = ""+alfa[i]+alfa[j]+alfa[k]+alfa[l];
                            hashSenha = ut.md5Decoder(senha);
                            ai.getAndIncrement();
                            elapsed= (int) ((System.currentTimeMillis()-start)/1000);
                                if (elapsed>60&&ok) {
                                    System.out.println("hashs/min"+ai.get());
                                    ok=false;
                                }
                            for (int m = 0; m < hash.length; m++) {
                                if (hash[m].equals(hashSenha)) {
                                elapsed= (int) ((System.currentTimeMillis()-start)/1000);
                                if (elapsed<10) {
                                    time = "00:0"+(int)elapsed;
                                } else if (elapsed<60) {
                                    time = "00:"+(int)elapsed;
                                } else if ((elapsed/60)%1==0) {
                                    elapsed=elapsed/60;
                                    time = (int)elapsed+":00";
                                } else {
                                    elapsed=elapsed/60;
                                    timeReal  = (int) ((elapsed%1)*60);
                                    time = (int)elapsed+":"+timeReal;
                                }
                                this.setName("find");
                                try {
                                    fw.write(senha + " - " + hash[m] + " - " + time + "\r\n");
                                    fw.flush();
                                } catch (IOException ex) {
                                    Logger.getLogger(HashThread.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                System.out.println(senha + " - " + hash[m] + " - " + time);
                                break block;
                            }
                            }
                        }
                    }
                }
            }
            this.setName("end");
        }
    }
    
    public void hash5Digitos() {
        block: while(!(this.getName().equals("find")) && !(this.getName().equals("end"))) {
            for (int i = 0+position; i < alfa.length; i+=threadDivisor) {
                for (int j = 0; j < alfa.length; j++) {
                   if (this.getName().equals("find"))break block;
                    for (int k = 0; k < alfa.length; k++) {
                        for (int l = 0; l < alfa.length; l++) {
                            for (int m = 0; m < alfa.length; m++) {
                                senha = ""+alfa[i]+alfa[j]+alfa[k]+alfa[l]+alfa[m];
                                hashSenha = ut.md5Decoder(senha);
                                ai.getAndIncrement();
                                elapsed= (int) ((System.currentTimeMillis()-start)/1000);
                                if (elapsed>60&&ok) {
                                    System.out.println("hashs/min"+ai.get());
                                    ok=false;
                                }
                                for (int n = 0; n < hash.length; n++) {
                                    if (hash[n].equals(hashSenha)) {
                                        elapsed= (int) ((System.currentTimeMillis()-start)/1000);
                                        if (elapsed<10) {
                                            time = "00:0"+(int)elapsed;
                                        } else if (elapsed<60) {
                                            time = "00:"+(int)elapsed;
                                        } else if ((elapsed/60)%1==0) {
                                            time = (int)elapsed+":00";
                                        } else {
                                            elapsed=elapsed/60;
                                            timeReal  = (int) ((elapsed%1)*60);
                                            time = (int)elapsed+":"+timeReal;
                                        }
                                        this.setName("find");
                                        try {
                                            fw.write(senha + " - " + hash[n] + " - " + time + "\n");
                                            fw.flush();
                                        } catch (IOException ex) {
                                            Logger.getLogger(HashThread.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        System.out.println(senha + " - " + hash[n] + " - " + time);
                                        break block;
                                    }
                                }
                            }
                        }
                    }
                }
                }
                this.setName("end");
        }
    }
    
    public void hash6Digitos() {
         block: while(!(this.getName().equals("find")) && !(this.getName().equals("end"))) {
            for (int i = 0+position; i < alfa.length; i+=threadDivisor) {
                for (int j = 0; j < alfa.length; j++) {
                    if (this.getName().equals("find"))break block;
                    for (int k = 0; k < alfa.length; k++) {
                        for (int l = 0; l < alfa.length; l++) {
                            for (int m = 0; m < alfa.length; m++) {
                                for (int n = 0; n < alfa.length; n++) {
                                    senha = ""+alfa[i]+alfa[j]+alfa[k]+alfa[l]+alfa[m]+alfa[n];
                                    hashSenha = ut.md5Decoder(senha);
                                    for (int o = 0; o < hash.length; o++) {
                                            if (hash[o].equals(hashSenha)) {
                                            elapsed= (int) ((System.currentTimeMillis()-start)/1000);
                                            if (elapsed<10) {
                                                time = "00:0"+(int)elapsed;
                                            } else if (elapsed<60) {
                                                time = "00:"+(int)elapsed;
                                            } else if ((elapsed/60)%1==0) {
                                                time = (int)elapsed+":00";
                                            } else {
                                                elapsed=elapsed/60;
                                                timeReal  = (int) ((elapsed%1)*60);
                                                time = (int)elapsed+":"+timeReal;
                                            }
                                            this.setName("find");
                                            try {
                                            fw.write(senha + " - " + hash[o] + " - " + time + "\n");
                                            fw.flush();
                                            } catch (IOException ex) {
                                            Logger.getLogger(HashThread.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            System.out.println(senha + " - " + hash[o] + " - " + time);
                                            break block;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.setName("end");
        }
     }
    
    public void hash7Digitos() {
         block: while(!(this.getName().equals("find")) && !(this.getName().equals("end"))) {
            for (int i = 0+position; i < alfa.length; i+=threadDivisor) {
                for (int j = 0; j < alfa.length; j++) {
                    if (this.getName().equals("find"))break block;
                    for (int k = 0; k < alfa.length; k++) {
                        for (int l = 0; l < alfa.length; l++) {
                            for (int m = 0; m < alfa.length; m++) {
                                for (int n = 0; n < alfa.length; n++) {
                                    for (int o = 0; o < alfa.length; o++) {
                                        senha = ""+alfa[i]+alfa[j]+alfa[k]+alfa[l]+alfa[m]+alfa[n]+alfa[o];
                                        hashSenha = ut.md5Decoder(senha);
                                        for (int p = 0; p < hash.length; p++) {
                                            if (hash[p].equals(hashSenha)) {
                                                elapsed= (int) ((System.currentTimeMillis()-start)/1000);
                                            if (elapsed<10) {
                                                time = "00:0"+(int)elapsed;
                                            } else if (elapsed<60) {
                                                time = "00:"+(int)elapsed;
                                            } else if ((elapsed/60)%1==0) {
                                                time = (int)elapsed+":00";
                                            } else {
                                                elapsed=elapsed/60;
                                                timeReal  = (int) ((elapsed%1)*60);
                                                time = (int)elapsed+":"+timeReal;
                                            }
                                            try {
                                            fw.write(senha + " - " + hash[p] + " - " + time + "\n");
                                            fw.flush();
                                            } catch (IOException ex) {
                                            Logger.getLogger(HashThread.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            this.setName("find");
                                            System.out.println(senha + " - " + hash[p] + " - " + time);
                                            break block;
                                            }
                                        }
                                    }
                                    
                                }
                            }
                        }
                    }
                }
            }
            this.setName("end");
        }
     }
     
    public void hash8Digitos() {
        hash4Digitos();
        hash5Digitos();
        hash6Digitos();
        hash7Digitos();
    }

    //public String getHash() {
    //    return hash;
    //}

    @Override
    public String toString() {
        return ""+senha;
    }

    
}