package com.example.springbootdemo.encryptservice;

import cn.hutool.core.codec.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RsaHelper {
    /**
     * 缓存公钥与私钥组
     */
    private static Map<String, Object> keyMap = new HashMap<>();

    /**
     * 随机生成密钥对
     *
     * @throws NoSuchAlgorithmException
     */
    public static String genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        //  下面两行可以自行设定随机种子
        //        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        //        random.setSeed(slatKey.getBytes());
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(2048, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 得到公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        // 得到私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        String strPublicKey = new String(Base64.encode(publicKey.getEncoded()));
        // 将公钥和私钥保存到Map
        keyMap.put(strPublicKey, privateKey);
        return strPublicKey;
    }

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.decode(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encode(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decode(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decode(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

    public static void main(String[] args) throws Exception {

        //生成公钥和私钥
        genKeyPair();
        //加密字符串
        String message = "sasddddfdddfeeeeeeeesasddddfdddfeeeeeeeesasddddfdddfeeeeeeeesasddddfdddfeeeeeeeesasddddfdddfeeeeeeeesasddddfdddfeeeeeeeesasddddfdddfeeeeeeeesasddddfdddfeeeeeeeesasddddfdddfeeeeeeeesasddddfdddfeeeeeeeesasddddfdddfeeeeeeeesasddddfdddfeeeeeeeedfgvb";
        String strPublicKey = genKeyPair();
        System.out.println("随机生成的公钥为:" + strPublicKey);

        Object privatePair = keyMap.get(strPublicKey);
        RSAPrivateKey privateKey = (RSAPrivateKey) privatePair;
        String strPrivateKey = new String(Base64.encode((privateKey.getEncoded())));

        System.out.println("随机生成的私钥为:" + strPrivateKey);
        String messageEn = encrypt(message, strPublicKey);

        System.out.println(message + "\t加密后的字符串为:" + messageEn);
        String messageDe = decrypt(messageEn, strPrivateKey);
        System.out.println("还原后的字符串为:" + messageDe);
    }
}