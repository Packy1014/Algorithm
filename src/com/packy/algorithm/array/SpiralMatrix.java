/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
    Input:
        [
            [ 1, 2, 3 ],
            [ 4, 5, 6 ],
            [ 7, 8, 9 ]
        ]
    Output:
        [1,2,3,6,9,8,7,4,5]

Example 2:
    Input:
        [
            [1, 2, 3, 4],
            [5, 6, 7, 8],
            [9,10,11,12]
        ]
    Output:
        [1,2,3,4,8,12,11,10,9,5,6,7]
*/
package com.packy.algorithm.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    private enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }

    private static List<Integer> mySolution(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix.length == 0) {
            return result;
        }
        int topBoundary = 0;
        int rightBoundary = matrix[0].length - 1;
        int bottomBoundary = matrix.length - 1;
        int leftBoundary = 0;
        int r = 0;
        int c = 0;
        Direction direction = Direction.RIGHT;
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            result.add(matrix[r][c]);
            if (direction == Direction.RIGHT) {
                if (c == rightBoundary) {
                    topBoundary++;
                    direction = Direction.DOWN;
                    r++;
                } else {
                    c++;
                }
            } else if (direction == Direction.DOWN) {
                if (r == bottomBoundary) {
                    rightBoundary--;
                    direction = Direction.LEFT;
                    c--;
                } else {
                    r++;
                }
            } else if (direction == Direction.LEFT) {
                if (c == leftBoundary) {
                    bottomBoundary--;
                    direction = Direction.UP;
                    r--;
                } else {
                    c--;
                }
            } else if (direction == Direction.UP) {
                if (r == topBoundary) {
                    leftBoundary++;
                    direction = Direction.RIGHT;
                    c++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }

    private static List<Integer> bestSolution(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        mySolution(matrix).forEach(System.out::println);
        bestSolution(matrix).forEach(System.out::println);
    }
}
