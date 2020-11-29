/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
    1. Open brackets must be closed by the same type of brackets.
    2. Open brackets must be closed in the correct order.

Example 1:
    Input: s = "()"
    Output: true

Example 2:
    Input: s = "()[]{}"
    Output: true

Example 3:
    Input: s = "(]"
    Output: false

Example 4:
    Input: s = "([)]"
    Output: false

Example 5:
    Input: s = "{[]}"
    Output: true
 */
package com.packy.algorithm.week1;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    private static boolean bestSolution(String s) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        hashMap.put(')', '(');

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                if (stack.isEmpty() || !hashMap.get(c).equals(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(bestSolution("()"));
    }
}
