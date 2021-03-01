package com.example.springbootdemo.dimitefaze;

public class TestSeri {
    private Seri seri;

    public TestSeri(Seri seri) {
        this.seri = seri;
    }


    public static void main(String[] args) {
        TestSeri testSeri = new TestSeri(new Serition());
        testSeri.seri.seri();
    }
}
