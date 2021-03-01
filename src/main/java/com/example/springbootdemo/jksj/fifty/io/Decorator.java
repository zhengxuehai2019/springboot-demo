package com.example.springbootdemo.jksj.fifty.io;

import java.io.*;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

public class Decorator {
    static {
        System.out.println("读取DB");

    }

    public static void main(String[] args) throws FileNotFoundException {
        InputStream stream = new FileInputStream("");
        InputStream bStream = new BufferedInputStream(stream);
        InputStream dStream = new DataInputStream(stream);
    }

    public static Enumeration emumeration(final Collection c) {
        return new Enumeration() {
            Iterator i = c.iterator();

            public boolean hasMoreElments() {
                return i.hasNext();
            }

            @Override
            public boolean hasMoreElements() {
                return false;
            }

            public Object nextElement() {
                return i.next();
            }
        };
    }
}
