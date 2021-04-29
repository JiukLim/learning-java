package com.example.demo.leetcode;

/**
 * https://leetcode.com/problems/palindrome-number/
 * <p>
 * integer x가 주어집니다. 만약 x가 palindrome integer이면 true를 반환합니다.
 * <p>
 * integer는 ~이 것이 앞쪽으로부터 뒷쪽으로 같이 읽어 질 때 palindrome 입니다.
 * 예를들어 121이면 palindrom이고, 123는 palindrome이 아닙니다.
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(12321));
    }

//    public static boolean isPalindrome(int x) {
//        String strX = String.valueOf(x);
//        StringBuilder reverseXStrBuilder = new StringBuilder();
//        for (int i = strX.length() - 1; i >= 0; i--) {
//            reverseXStrBuilder.append(strX.charAt(i));
//        }
//
//        String reverseStrX = reverseXStrBuilder.toString();
//
//        if (strX.equals(reverseStrX)) {
//            return true;
//        }
//        return false;
//    }

    public static boolean isPalindrome(int x) {
        String strX = String.valueOf(x);
        boolean palindrome = true;
        for (int i = 0; i < strX.length(); i++) {
            if (strX.charAt(i) != strX.charAt(strX.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
