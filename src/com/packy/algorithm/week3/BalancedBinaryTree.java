/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as: a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
package com.packy.algorithm.week3;

public class BalancedBinaryTree {
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

    public static int nodeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftNodeHeight = nodeHeight(node.left);
        if (leftNodeHeight == -1) {
            return -1;
        }
        int rightNodeHeight = nodeHeight(node.right);
        if (rightNodeHeight == -1) {
            return -1;
        }
        if (Math.abs(leftNodeHeight - rightNodeHeight) > 1) {
            return -1;
        }
        return Math.max(leftNodeHeight, rightNodeHeight) + 1;
    }

    public static boolean bestSolution(TreeNode root) {
        return nodeHeight(root) != -1;
    }
}
