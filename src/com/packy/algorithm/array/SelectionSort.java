package com.packy.algorithm.array;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] numbs) {
        for (int i = 0; i < numbs.length - 1; i++) {
            int minNumbIndex = i;
            for (int j = i + 1; j < numbs.length; j++) {
                if (numbs[j] < numbs[minNumbIndex]) {
                    minNumbIndex = j;
                }
            }
            int temp = numbs[i];
            numbs[i] = numbs[minNumbIndex];
            numbs[minNumbIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbs = {6, 9, 2, 17, 8796, 45, 89, -2, -546, 0};
        selectionSort(numbs);
        System.out.println(Arrays.toString(numbs));
    }
}
