/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:
    Input: 5
    Output:
        [
              [1],
             [1,1],
            [1,2,1],
           [1,3,3,1],
          [1,4,6,4,1]
        ]
*/
package com.packy.algorithm.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
    private static List<List<Integer>> mySolution(int numbRows) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> row;
        for (int i = 0; i < numbRows; i++) {
            if (i == 0) {
                row = new LinkedList<>();
                row.add(1);
                result.add(row);
                continue;
            } else if (i == 1) {
                row = new LinkedList<>();
                row.add(1);
                row.add(1);
                result.add(row);
                continue;
            }
            row = new LinkedList<>();
            row.add(1);
            for (int j = 0; j < i - 1; j++) {
                List<Integer> lastRow = result.getLast();
                row.add(lastRow.get(j) + lastRow.get(j + 1));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

    private static List<List<Integer>> bestSolution(int numbRows) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < numbRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            result.add(new ArrayList<>(row));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(mySolution(5));
        System.out.println(bestSolution(3));
    }
}
