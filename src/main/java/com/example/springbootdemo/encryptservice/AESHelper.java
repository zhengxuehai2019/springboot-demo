package com.example.springbootdemo.encryptservice;


import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESHelper {

    public static String encrypt(String content, String slatKey, String vectorKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKey secretKey = new SecretKeySpec(slatKey.getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(vectorKey.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        byte[] encrypted = cipher.doFinal(content.getBytes());
        return Base64.encodeBase64String(encrypted);
    }

    public static String decrypt(String base64Content, String slatKey, String vectorKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKey secretKey = new SecretKeySpec(slatKey.getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(vectorKey.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] content = Base64.decodeBase64(base64Content);
        byte[] encrypted = cipher.doFinal(content);
        return new String(encrypted);
    }

    public static void main(String[] args) throws Exception {
        String str = "=1";
        String key = "abcdefghijkl.opq";
        String vi = "toCross......sds";
        String encrypt = encrypt(str, key, vi);
        System.out.println("加密后的Base64：" + encrypt);
        String decrypt = decrypt(encrypt, key, vi);
        System.out.println("解密后：" + decrypt);

//        String decrypt = decrypt(base64Sign, key, vi);
//        System.out.println("解密后：" + decrypt);


    }
}
