/*
Given an array of integers nums, write a method that returns the "pivot" index of this array.
We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:
    Input:
        nums = [1, 7, 3, 6, 5, 6]
    Output: 3
        Explanation:
    The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
    Also, 3 is the first index where this occurs.


Example 2:
    Input:
        nums = [1, 2, 3]
    Output: -1
        Explanation:
    There is no index that satisfies the conditions in the problem statement.

Note:
    The length of nums will be in the range [0, 10000].
    Each element nums[i] will be an integer in the range [-1000, 1000].
*/
package com.packy.algorithm.array;

public class FindPivotIndex {
    private static int mySolution(int[] nums) {
        if (nums.length == 0)
            return -1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                left += nums[i - 1];
            }
            if (left == sum - left - nums[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int bestSolution(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x : nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(mySolution(nums));
        System.out.println(bestSolution(nums));
    }

}

