/**
 * LeetCode #32 - Longest Valid Parentheses
 * Difficulty : Hard
 * Topics     : String, Dynamic Programming, Stack, Bracket Sequences
 * Date       : 2026-10-03
 * URL        : https://leetcode.com/problems/longest-valid-parentheses/
 */

class Solution {
    class Node{
        int idx;
        char ch;
        Node(int idx, char ch){
            this.idx = idx;
            this.ch = ch;
        }
        // @Override
        // public String toString(){
        //     return " [" + idx + " " + ch + "] ";
        // }
    }
    public int longestValidParentheses(String s) {
        Stack<Node> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(new Node(i, '('));
            }
            else{
                if(stack.isEmpty()){
                    stack.push(new Node(i, ')'));
                }
                else{
                    if(stack.peek().ch == ')'){
                        stack.push(new Node(i, ')'));
                    }
                    else{
                        stack.pop();
                    }
                }
            }
        }

        int last = s.length()-1;
        int max = 0;
        while(!stack.isEmpty()){
            int pidx = stack.pop().idx;
            max = Math.max(max, last- pidx);
            last = pidx - 1;
        }

        max = Math.max(max, last+1);
        return max;
    }
}
