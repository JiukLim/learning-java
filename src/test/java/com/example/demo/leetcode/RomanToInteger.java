package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * <p>
 * Roman numeral들은 7개의 다른 심볼로 표현됩니다.
 * I, V, X, L, C, D and M
 * <p>
 * I => 1
 * V => 5
 * X => 10
 * L => 50
 * C => 100
 * D => 500
 * M => 1000
 * 예를 들어
 * 2는 II로 쓰여집니다.
 * 12는 XII로 쓰여집니다.
 * 27은 XX+V+II로 쓰여집니다.
 * Roman 숫자들은 대개 왼쪽부터 오른쪽으로 큰 숫자부터 작은 숫자로 쓰여집니다.
 * 하지만, 숫자 4는 IIII가 아닙니다. 대신에 4는 IV로 쓰여집니다.
 * 1이 5이전에 있는 우리는 이것을 빼기 때문에 4를 만듭니다.
 * 같은 원리도 9숫자도 허용됩니다. => IX
 * 빼기가 사용되어 지는 6개의 예제가 있습ㄴ디ㅏ.
 * IV => 4
 * IX => 9
 * XL => 40
 * XC => 90
 * CD => 400
 * CM => 900
 * <p>
 * roman이 들어오면 INTEger로 변환하는 메서드를 작성해야 한다.
 */
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> numericMap = new HashMap<>();
        numericMap.put("I", 1);
        numericMap.put("V", 5);
        numericMap.put("X", 10);
        numericMap.put("L", 50);
        numericMap.put("C", 100);
        numericMap.put("D", 500);
        numericMap.put("M", 1000);
        numericMap.put("IV", 4);
        numericMap.put("IX", 9);
        numericMap.put("XL", 40);
        numericMap.put("XC", 90);
        numericMap.put("CD", 400);
        numericMap.put("CM", 900);

        int result = 0;
        int curIdx = 0;
        while (curIdx < s.length()) {
            if (curIdx < s.length() - 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(s.charAt(curIdx));
                stringBuilder.append(s.charAt(curIdx + 1));
                String doubleTarget = stringBuilder.toString();
                if (Objects.nonNull(numericMap.get(doubleTarget))) {
                    result += numericMap.get(doubleTarget);
                    curIdx += 2;
                    continue;
                }
            }

            String target = String.valueOf(s.charAt(curIdx));
            result += numericMap.get(target);
            curIdx++;
        }
        return result;
    }
}
