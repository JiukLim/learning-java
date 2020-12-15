package com.example.demo.execute;

import java.util.ArrayList;
import java.util.List;

public class TestJava {
    // 만약 이렇게 있으면 class loader 단계 에서는 심볼릭 레퍼런스로 실제로는 치환되지 않음.
    List<String> ar = new ArrayList<>();

    public static void main(String[] args) {
        // class loader?
        System.out.println("class loader ? : " + TestJava.class.getClassLoader());
        // extends하지 않은 클래스의 super class는 무엇일가?
        System.out.println("super class ? : " + TestJava.class.getSuperclass());
    }
}
