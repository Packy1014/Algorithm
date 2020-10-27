package com.packy.algorithm.array;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] numbs) {
        for (int i = 0; i < numbs.length - 1; i++) {
            for (int j = numbs.length - 1; j > i; j--) {
                if (numbs[j] < numbs[j - 1]) {
                    int temp = numbs[j];
                    numbs[j] = numbs[j - 1];
                    numbs[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numbs = {6, 9, 2, 17, 8796, 45, 89, -2, -546, 0};
        bubbleSort(numbs);
        System.out.println(Arrays.toString(numbs));
    }
}
