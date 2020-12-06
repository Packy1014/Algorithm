/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:
    Given the below binary tree and sum = 22,
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
package com.packy.algorithm.week3;

public class PathSum {
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

    public static boolean isValid(TreeNode node, int sum) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return sum == node.val;
        return isValid(node.left, sum - node.val) || isValid(node.right, sum - node.val);
    }

    public static boolean bestSolution(TreeNode root, int sum) {
        return isValid(root, sum);
    }
}
