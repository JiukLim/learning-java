package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SimpleTest {

    @Test
    @DisplayName("산술연산자")
    public void test() {
        int a = 1;
        int b = 1;
        Assertions.assertEquals(2, a + b);
    }
}
