/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author dogma
 */
public class hash {
    
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
byte messageDigest[] = algorithm.digest("ABAU".getBytes("UTF-8"));
 
StringBuilder hexString = new StringBuilder();
for (byte b : messageDigest) {
  hexString.append(String.format("%02X", 0xFF & b));
}
String senha = hexString.toString();
        System.out.println(senha);
    }
}
