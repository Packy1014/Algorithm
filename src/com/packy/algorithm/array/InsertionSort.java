package com.packy.algorithm.array;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] numbs) {
        for (int i = 1; i < numbs.length; i++) {
            int j = i;
            while (j > 0) {
                if (numbs[j] < numbs[j - 1]) {
                    int temp = numbs[j];
                    numbs[j] = numbs[j - 1];
                    numbs[j - 1] = temp;
                    j--;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numbs = {6, 9, 2, 17, 8796, 45, 89, -2, -546, 0};
        insertionSort(numbs);
        System.out.println(Arrays.toString(numbs));
    }
}
