package com.example.demo.learn.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class BookTest {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    /**
     * 메서드에 접근하여 사용하는 방법
     */
    public static void test4() {
        Book book = new Book();
        Class<Book> bookClass = Book.class;
        Arrays.stream(bookClass.getDeclaredMethods()).forEach(m -> {
            try {
                m.invoke(book);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * annotation선언해서 적용하고 그 값 가져오기
     */
    public static void test3() {
        Class<Book> bookClass = Book.class;
        // class에 붙은 annotation가져오기
        System.out.println(bookClass.getDeclaredAnnotations());
        Book book = new Book();
        // field들을 돌면서 어노테이션이 붙어 있으면 MySampleAnno 어노테이션까지 출력하기
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            MySampleAnno declaredAnnotation = f.getDeclaredAnnotation(MySampleAnno.class);
            try {
                f.setAccessible(true);
                System.out.println(f.get(book) + ", " + declaredAnnotation);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

    }

    /**
     * reflection에서 declareFields와 fields의 차이
     */
    public static void test1() {
        Class<Book> bookClass = Book.class;
        // 필드들 가져오기 (1)
        System.out.println("---bookClass.getDeclaredFields()----");
        // getDeclaredFields을 하면 private, protected, public 모두 접근
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);
        System.out.println("---bookClass.getFields()----");
        // 필드들 가져오기 (2)
        // getFields를 하면 Public인 필드들만 접근
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);
    }

    /**
     * reflection으로 값 가져오기
     */
    public static void test2() {
        Class<Book> bookClass = Book.class;
        System.out.println("---reflection으로 static필드 가져오기 ----");
        try {
            Field field = bookClass.getDeclaredField("AA");
            field.setAccessible(true);
            System.out.println(field.get(null));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // instance변수는 어떻게 가져올까?
        System.out.println("---reflection으로 instance필드 가져오기----");
        try {
            Book book = new Book();
            Field instanceField = bookClass.getDeclaredField("a");
            instanceField.setAccessible(true);
            System.out.println(instanceField.get(book));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
