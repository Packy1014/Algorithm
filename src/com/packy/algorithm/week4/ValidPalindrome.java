/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
    Input: "A man, a plan, a canal: Panama"
    Output: true

Example 2:
    Input: "race a car"
    Output: false
 */
package com.packy.algorithm.week4;

public class ValidPalindrome {
    private static final int[] charMap = new int[256];

    static {
        for (int i = 0; i < 10; i++) {
            charMap[i + '0'] = 1 + i;  // numeric
        }
        for (int i = 0; i < 26; i++) {
            charMap[i + 'a'] = charMap[i + 'A'] = 11 + i;  //alphabetic, ignore cases
        }
    }

    public static boolean bestSolution(String str) {
        char[] strArray = str.toCharArray();
        int start = 0;
        int end = strArray.length - 1;
        while (start < end) {
            int head = charMap[strArray[start]];
            int tail = charMap[strArray[end]];
            if (head == 0) {
                start++;
            } else if (tail == 0) {
                end--;
            } else if (head == tail) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(bestSolution("A man, a plan, a canal: Panama"));
    }
}
