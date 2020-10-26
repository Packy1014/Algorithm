/*
Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
    Input:
        digits = [1,2,3]
    Output:
        [1,2,4]
    Explanation:
        The array represents the integer 123.
Example 2:
    Input:
        digits = [4,3,2,1]
    Output:
        [4,3,2,2]
    Explanation:
        The array represents the integer 4321.
Example 3:
    Input:
        digits = [0]
    Output:
        [1]

Constraints:
    1 <= digits.length <= 100
    0 <= digits[i] <= 9
*/
package com.packy.algorithm.array;

import java.util.Arrays;

public class PlusOne {
    private static int[] mySolution(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int remainder = (digits[i] + 1) % 10;
            digits[i] = remainder;
            if (remainder > 0) {
                break;
            } else if (i == 0) {
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                System.arraycopy(digits, 0, newDigits, 1, digits.length);
                digits = newDigits;
            }
        }
        return digits;
    }

    private static int[] bestSolution(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        int[] digits_1 = {9, 9};
        int[] digits_2 = {9, 9};
        System.out.println(Arrays.toString(mySolution(digits_1)));
        System.out.println(Arrays.toString(bestSolution(digits_2)));
    }
}