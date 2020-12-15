package com.example.demo;

import com.example.demo.util.AES256CryptUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AesCryptTest {

    @Test
    @DisplayName("같은 평문이면 암호화된 문장도 같음1")
    public void test1() throws Exception {
        AES256CryptUtil util = new AES256CryptUtil();
        String abc = "임지욱";
        String first = util.encrypt(abc);
        String second = util.encrypt(abc);
        System.out.println(first);
        System.out.println(second);
        System.out.println(util.decrypt(first));
        System.out.println(util.decrypt(second));
    }

    @Test
    @DisplayName("같은 평문이면 암호화된 문장도 같음2")
    public void test2() throws Exception {
        AES256CryptUtil util = new AES256CryptUtil();
        String abc = "오노소";
        String first = util.encrypt(abc);
        String second = util.encrypt(abc);
        System.out.println(first);
        System.out.println(second);
        System.out.println(util.decrypt(first));
        System.out.println(util.decrypt(second));
    }
}
