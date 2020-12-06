/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]
 */
package com.packy.algorithm.week3;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2 {
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

    public static void iterateNode(List<List<Integer>> list, TreeNode node, int height) {
        if (node == null) {
            return;
        }
        if (list.size() < height) {
            list.add(0, new LinkedList<>());
        }
        list.get(list.size() - height).add(node.val);
        iterateNode(list, node.left, height + 1);
        iterateNode(list, node.right, height + 1);
    }

    public static List<List<Integer>> bestSolution(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        iterateNode(list, root, 1);
        return list;
    }
}
