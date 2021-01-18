package com.example.demo.learn.reflection;

public class Book {
    private static final String AA = "aaaa";
    private static String BB = "bbb";
    private String a = "a";
    @MySampleAnno
    public String d = "d";

    protected String e = "e";

    public Book() {
    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    public void f() {
        System.out.println("F");
    }

    public void g() {
        System.out.println("g");
    }

    public int h() {
        return 100;
    }
}
