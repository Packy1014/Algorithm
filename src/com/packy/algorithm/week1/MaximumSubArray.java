/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
    Input: nums = [1]
    Output: 1

Example 3:
    Input: nums = [0]
    Output: 0

Example 4:
    Input: nums = [-1]
    Output: -1

Example 5:
    Input: nums = [-2147483647]
    Output: -2147483647
 */
package com.packy.algorithm.week1;

public class MaximumSubArray {

    public static int bestSolution(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(bestSolution(nums));
    }
}
