/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

Example 1:
    Input: nums = [1,3,5,6], target = 5
    Output: 2

Example 2:
    Input: nums = [1,3,5,6], target = 2
    Output: 1

Example 3:
    Input: nums = [1,3,5,6], target = 7
    Output: 4

Example 4:
    Input: nums = [1,3,5,6], target = 0
    Output: 0

Example 5:
    Input: nums = [1], target = 0
    Output: 0
 */
package com.packy.algorithm.week1;

public class SearchInsertPosition {

    public static int mySolution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            } else if (i == nums.length - 1) {
                return nums.length;
            }
        }
        return 0;
    }

    public static int bestSolution(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(mySolution(nums, 7));
        System.out.println(bestSolution(nums, 7));
    }
}
