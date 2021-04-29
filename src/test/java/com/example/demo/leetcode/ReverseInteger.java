package com.example.demo.leetcode;

/**
 * 다시 풀어볼 필요 있음.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int num = 1234;

        int result = reverse(num);

        System.out.println(result);
    }

    public static int reverse(int x) {
        String originStr = String.valueOf(x);
        StringBuilder reverseStrBuilder = new StringBuilder();
        for (int i = originStr.length() - 1; i >= 0; i--) {
            reverseStrBuilder.append(originStr.charAt(i));
        }
        String reverse = reverseStrBuilder.toString();
        String maxValueStr = String.valueOf(Integer.MAX_VALUE);
        if (reverse.compareTo(maxValueStr) > 0) {
            return 0;
        }
        return Integer.parseInt(reverseStrBuilder.toString());
    }
}

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * 32비트 integer x가 주어진다. 이것의 digits를 역으로 반환한다.
 * 만약 역 x가 32bit ingeter범위를 넘어선다면 0을 리턴한다.
 * <p>
 * 64비트 Integer를 저장하는 것을 허락하지 않는 환경이라고 가정한다.
 * <p>
 * <p>
 * <p>
 * 해결방법1)
 * 스트링으로 변환해서 리버스로 돌리고, 이걸 int값으로 돌렸다가 다시 변환했을 때 변환값이 다르면 범위를 넘어서는 것이니 0으로 리턴한다.
 */
