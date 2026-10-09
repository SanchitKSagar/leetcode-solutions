/**
 * LeetCode #1648 - Minimum Insertions to Balance a Parentheses String
 * Difficulty : Medium
 * Topics     : String, Stack, Greedy, Bracket Sequences
 * Date       : 2026-10-09
 * URL        : https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
 */

class Solution {

    public int minInsertions(String s) {
        int insertions = 0;
        int leftCount = 0;
        int length = s.length();
        int index = 0;
        while (index < length) {
            char c = s.charAt(index);
            if (c == '(') {
                leftCount++;
                index++;
            } else {
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    insertions++;
                }
                if (index < length - 1 && s.charAt(index + 1) == ')') {
                    index += 2;
                } else {
                    insertions++;
                    index++;
                }
            }
        }
        insertions += leftCount * 2;
        return insertions;
    }
}
