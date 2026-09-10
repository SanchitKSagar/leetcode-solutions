/**
 * LeetCode #2347 - Count Nodes Equal to Average of Subtree
 * Difficulty : Medium
 * Topics     : Tree, Depth-First Search, Binary Tree
 * Date       : 2026-09-10
 * URL        : https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        if(root == null)
            return 0;
        average(root);
        return res;
    }

    public int[] average(TreeNode root){
        // 1d Array with 0-> number of node, 1-> Sum
        if(root == null){
            return new int[] {0,0};
        }
        int[] left = average(root.left);
        int[] right = average(root.right);
        int nodeCount = left[0] + right[0] + 1;
        int sum = left[1] + right[1] + root.val;

        if(Math.round(sum/nodeCount) == root.val)
            res ++;
        return new int[] {nodeCount, sum};
    }
}
