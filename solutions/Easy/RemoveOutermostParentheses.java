/**
 * LeetCode #1078 - Remove Outermost Parentheses
 * Difficulty : Easy
 * Topics     : String, Stack, Bracket Sequences
 * Date       : 2026-10-08
 * URL        : https://leetcode.com/problems/remove-outermost-parentheses/
 */

class Solution {

    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
        }
        return res.toString();
    }
}
