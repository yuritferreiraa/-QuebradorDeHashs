/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dogma
 */
public class UtilThread {
    private MessageDigest md;
    private String crypto;
    
    
    public static void intervalo(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(UtilThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String md5Decoder(String senha) {
        try {
                        md = MessageDigest.getInstance("MD5");
                        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
                        crypto = hash.toString(16);
                        if (crypto.length() % 2 != 0) {
                            crypto = "0" + crypto;
                        }
                        } catch (NoSuchAlgorithmException ex) {
                        System.out.println("Um erro ocorreu ao tentar gerar o Hash da palavra");
                        }
        return crypto;
    }
    
    public FileWriter arquivar(FileWriter fw, int thread) {
        try {
            return new FileWriter(new File("Arquivo"+thread+".txt"));
        } catch (IOException ex) {
            Logger.getLogger(UtilThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
