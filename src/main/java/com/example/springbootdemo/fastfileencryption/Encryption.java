package com.example.springbootdemo.fastfileencryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Encryption {
    public Encryption() {
    }

    public static void operation(String s_File, int key) throws IOException {
        File inFile = new File(s_File);
        FileInputStream input = new FileInputStream(inFile);
        int content = input.read();
        input.close();
        RandomAccessFile output = new RandomAccessFile(s_File, "rw");
        output.write(content ^ key);
        output.close();
    }
}
