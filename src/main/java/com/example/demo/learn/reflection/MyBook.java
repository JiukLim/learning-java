package com.example.demo.learn.reflection;

import java.util.Arrays;

public class MyBook {

    public static void main(String[] args) {
        Class<Book> bookClass = Book.class;

        System.out.println("---Arrays.stream(bookClass.getFields()).forEach(System.out::println);---");
        Arrays.stream(bookClass.getFields()).forEach(System.out::println); // public만 가져옴
        System.out.println("---Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);---");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println); // 모든 필드 가져옴..

        System.out.println("-----------");
        // private field까지 가져오기
        Book book = new Book();
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
