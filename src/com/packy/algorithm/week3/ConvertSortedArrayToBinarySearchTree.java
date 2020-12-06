/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:
    Given the sorted array: [-10,-3,0,5,9],
    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
        0
       / \
     -3   9
     /   /
   -10  5
 */
package com.packy.algorithm.week3;

public class ConvertSortedArrayToBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode createNode(int[] nums, int lowIndex, int highIndex) {
        if (lowIndex > highIndex) {
            return null;
        }
        int midIndex = lowIndex + (highIndex - lowIndex) / 2;
        TreeNode treeNode = new TreeNode(nums[midIndex]);
        treeNode.left = createNode(nums, lowIndex, midIndex - 1);
        treeNode.right = createNode(nums, midIndex + 1, highIndex);
        return treeNode;
    }

    public static TreeNode bestSolution(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return createNode(nums, 0, nums.length - 1);
    }
}
