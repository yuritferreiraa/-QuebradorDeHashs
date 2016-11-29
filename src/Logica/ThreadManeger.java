/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static Utilidades.UtilThread.intervalo;
import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author dogma
 */
public class ThreadManeger implements Runnable {
    private int terms;
    private int numThreads;
    private Thread[] th;
    private String hash[];
    private boolean threadFind;
    private String passFind = "Procurando";
    private int contEnd;
    public static AtomicInteger ai;
    
    public ThreadManeger(int num, int terms, String hash[]) {
    ai = new AtomicInteger(0);
    this.numThreads=num;
    th = new HashThread[num];
    this.terms=terms;
    this.hash=hash;
    }
    
    // cria por meio do laço as threads necessarias
    public void acionarThreds() {
        for (int i = 0; i < numThreads; i++) {
            th[i] = new HashThread(hash, terms, numThreads, i);
            th[i].start();
        }
    }
    
    // encerra todas as threads quando a senha é encontrada
    public void pararThreadsPorFind() {
        threadFind = true;
        for(int i = 0; i < th.length; i++) {
            th[i].setName("find");
        }
    }
    
    // verifica em todas as threads se foi possivel encontrar a senha    
    public void paraThreadsPorEnd() {
       intervalo(3000);
        for (int i = 0; i < th.length; i++) {
            if (th[i].getName().equals("end")) {
            contEnd++;
            th[i].setName("ok");
            }
        }
        if (contEnd>=numThreads) {
            threadFind=true;
            passFind="Senha não encontrada";
            System.out.println(passFind);
        }
    }
    
    // acompanha o funcionamento das threads
    public void monitor() {
        while (!threadFind) {
            intervalo(3000);
            for(int j = 0; j < th.length; j++) {
                if (th[j].getName().equals("find")) {
                    passFind = th[j].toString();
                    pararThreadsPorFind();
                    intervalo(100);
                    if (threadFind) break;
            }
                if (th[j].getName().equals("end")) {
                    paraThreadsPorEnd();
                }
            }
        }
        contEnd =0;
    }

    @Override
    public void run() {
        acionarThreds();
        monitor();
    }

    public String getPassFind() {
        return passFind;
    }
    
    
}
