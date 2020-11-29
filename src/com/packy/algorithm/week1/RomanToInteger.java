/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

Example 1:
    Input: s = "III"
    Output: 3

Example 2:
    Input: s = "IV"
    Output: 4

Example 3:
    Input: s = "IX"
    Output: 9

Example 4:
    Input: s = "LVIII"
    Output: 58
    Explanation: L = 50, V= 5, III = 3.

Example 5:
    Input: s = "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/
package com.packy.algorithm.week1;

import java.util.HashMap;

public class RomanToInteger {

    public static int mySolution(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        char[] sChar = s.toCharArray();
        int result = 0;
        for (int i = sChar.length - 1; i >= 0; i--) {
            int nextIndex = i - 1;
            if (nextIndex < 0) {
                result += hashMap.get(sChar[i]);
            } else {
                if (((sChar[i] == 'V' && sChar[nextIndex] == 'I') || (sChar[i] == 'X' && sChar[nextIndex] == 'I'))
                        || ((sChar[i] == 'L' && sChar[nextIndex] == 'X') || (sChar[i] == 'C' && sChar[nextIndex] == 'X'))
                        || ((sChar[i] == 'D' && sChar[nextIndex] == 'C') || (sChar[i] == 'M' && sChar[nextIndex] == 'C'))) {
                    result += (hashMap.get(sChar[i]) - hashMap.get(sChar[nextIndex]));
                    i = nextIndex;
                } else {
                    result += hashMap.get(sChar[i]);
                }
            }
        }
        return result;
    }

    public static int bestSolution(String s) {
        int sum = 0;
        if (s.contains("IV")) {
            sum -= 2;
        }
        if (s.contains("IX")) {
            sum -= 2;
        }
        if (s.contains("XL")) {
            sum -= 20;
        }
        if (s.contains("XC")) {
            sum -= 20;
        }
        if (s.contains("CD")) {
            sum -= 200;
        }
        if (s.contains("CM")) {
            sum -= 200;
        }

        char[] c = s.toCharArray();
        for (int count = 0; count <= s.length() - 1; count++) {
            if (c[count] == 'M') sum += 1000;
            if (c[count] == 'D') sum += 500;
            if (c[count] == 'C') sum += 100;
            if (c[count] == 'L') sum += 50;
            if (c[count] == 'X') sum += 10;
            if (c[count] == 'V') sum += 5;
            if (c[count] == 'I') sum += 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(mySolution("MCMXCIV"));
        System.out.println(bestSolution("MCMXCIV"));
    }
}
