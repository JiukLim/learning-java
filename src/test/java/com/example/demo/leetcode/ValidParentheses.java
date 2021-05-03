package com.example.demo.leetcode;

/**
 * 스트링이 주어지는데,
 * '(', ')', '{', '}', '[', ']'로 이루어져 있다.
 * input이 valid하려면
 * 1. 열린 괄호와 같은 괄호로 닫혀야 한다.
 * 2. 열린 괄호는 반드시 순서에 맞게 닫혀야 한다.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String input = "(";
        System.out.println("valid : " + isValid(input));
    }

    public static boolean isValid(String s) {
        char[] openBrackets = new char[s.length()];
        int openBracketIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                openBrackets[openBracketIdx++] = c;
            } else if (c == '}') {
                if (openBracketIdx == 0) {
                    return false;
                }
                char last = openBrackets[--openBracketIdx];
                if (last != '{') {
                    return false;
                }
            } else if (c == ')') {
                if (openBracketIdx == 0) {
                    return false;
                }
                char last = openBrackets[--openBracketIdx];
                if (last != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (openBracketIdx == 0) {
                    return false;
                }
                char last = openBrackets[--openBracketIdx];
                if (last != '[') {
                    return false;
                }
            }
        }

        if (openBracketIdx != 0) {
            return false;
        }
        return true;
    }
}
