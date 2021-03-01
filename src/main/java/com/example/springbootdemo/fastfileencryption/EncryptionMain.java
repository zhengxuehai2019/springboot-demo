package com.example.springbootdemo.fastfileencryption;

import java.io.IOException;

public class EncryptionMain {
    public static void main(String[] args) {
        try {
            Encryption.operation("E:\\englishfile.txt", 1);
            System.out.println("操作完成！");
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }
}
