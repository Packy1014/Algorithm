/*
Given a number N, return a string consisting of "0"s and "1"s that represents its value in base -2 (negative two).
The returned string must have no leading zeroes, unless the string is "0".

Example 1:
    Input: 2
    Output: "110"
    Explanation: (-2) ^ 2 + (-2) ^ 1 = 2

Example 2:
    Input: 3
    Output: "111"
    Explanation: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3

Example 3:
    Input: 4
    Output: "100"
    Explanation: (-2) ^ 2 = 4
 */
package com.packy.algorithm.math;

public class ConvertToBaseNegative2 {
    private static String bestSolution(int N) {
        StringBuilder res = new StringBuilder();
        while (N != 0) {
            res.append(N & 1);
            int a = N;
            N = -(N >> 1);

        }
        return res.length() > 0 ? res.reverse().toString() : "0";
    }

    public static void main(String[] args) {
        System.out.println(bestSolution(3));
    }
}
