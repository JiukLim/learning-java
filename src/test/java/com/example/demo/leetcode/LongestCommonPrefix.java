package com.example.demo.leetcode;

/**
 * string 배열 중에 가장 긴 공통의 prefix를 찾는다.
 * 없으면 ""을 반환한다.
 * <p>
 * Input: ["flower", "flow", "flight"]
 * output: "fl"
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] input = {"a"};
        String result = longestCommonPrefix(input);

        System.out.println(result);
    }

    private static String longestCommonPrefix(String[] strs) {
        String shortestWord = null;
        int shortestCount = 999999;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < shortestCount) {
                shortestCount = strs[i].length();
                shortestWord = strs[i];
            }
        }

        String longestCommonPrefix = "";
        for (int i = 0; i < shortestWord.length(); i++) {
            String commonCandidate = shortestWord.substring(0, i + 1);
            boolean isCommon = true;
            for (int j = 0; j < strs.length; j++) {
                if (!commonCandidate.equals(strs[j].substring(0, i + 1))) {
                    isCommon = false;
                    break;
                }
            }

            if (isCommon) {
                longestCommonPrefix = commonCandidate;
            } else {
                break;
            }

        }
        return longestCommonPrefix;
    }
}
