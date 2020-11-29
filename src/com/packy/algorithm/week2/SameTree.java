/*
Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:
    Input:     1         1
              / \       / \
             2   3     2   3
            [1,2,3],   [1,2,3]
    Output: true

Example 2:
    Input:     1         1
              /           \
             2             2
            [1,2],     [1,null,2]
    Output: false

Example 3:
    Input:     1         1
              / \       / \
             2   1     1   2
            [1,2,1],   [1,1,2]
    Output: false
 */
package com.packy.algorithm.week2;

import java.util.LinkedList;

public class SameTree {
    public class TreeNode {
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

    public void iterate(TreeNode t, LinkedList<Integer> l) {
        if (t != null) {
            l.add(t.val);
            iterate(t.left, l);
            iterate(t.right, l);
        } else {
            l.add(null);
        }
    }

    public boolean mySolution(TreeNode p, TreeNode q) {
        LinkedList<Integer> pl = new LinkedList<>();
        LinkedList<Integer> ql = new LinkedList<>();
        iterate(p, pl);
        iterate(q, ql);
        return pl.equals(ql);
    }

    public boolean bestSolution(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return bestSolution(p.left, q.left) && bestSolution(p.right, q.right);
    }
}
