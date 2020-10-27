/*
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

Example:
    Input:
        [
            [ 1, 2, 3 ],
            [ 4, 5, 6 ],
            [ 7, 8, 9 ]
        ]
    Output:
        [1,2,4,7,5,3,6,8,9]
*/
package com.packy.algorithm.array;

import java.util.Arrays;

public class DiagonalTraverse {
    private static int[] mySolution(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int maxRowIndex = matrix.length - 1;
        int maxColumnIndex = matrix[0].length - 1;
        int[] result = new int[matrix.length * matrix[0].length];
        boolean traverseUp = true;
        int nextItemRowIndex = 0;
        int nextItemColumnIndex = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[nextItemRowIndex][nextItemColumnIndex];
            if (traverseUp) {
                nextItemRowIndex -= 1;
                nextItemColumnIndex += 1;
            } else {
                nextItemRowIndex += 1;
                nextItemColumnIndex -= 1;
            }
            if (nextItemColumnIndex > maxColumnIndex) {
                nextItemColumnIndex -= 1;
                nextItemRowIndex += 2;
                traverseUp = false;
            } else if (nextItemRowIndex > maxRowIndex) {
                nextItemRowIndex -= 1;
                nextItemColumnIndex += 2;
                traverseUp = true;
            } else if (nextItemColumnIndex < 0) {
                nextItemColumnIndex += 1;
                traverseUp = true;
            } else if (nextItemRowIndex < 0) {
                nextItemRowIndex += 1;
                traverseUp = false;
            }
        }
        return result;
    }

    private static int[] bestSolution(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int r = 0;
        int c = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[r][c];
            if ((r + c) % 2 == 0) { // moving up
                if (c == n - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else {                // moving down
                if (r == m - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(mySolution(matrix)));
        System.out.println(Arrays.toString(bestSolution(matrix)));
    }
}
