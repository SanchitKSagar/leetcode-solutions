/**
 * LeetCode #2306 - Create Binary Tree From Descriptions
 * Difficulty : Medium
 * Topics     : Array, Hash Table, Tree, Binary Tree
 * Date       : 2026-06-07
 * URL        : https://leetcode.com/problems/create-binary-tree-from-descriptions/
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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> childs = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        for(int[] desc:descriptions){
            childs.add(desc[1]);
            if(!map.containsKey(desc[0]))
                map.put(desc[0], new TreeNode(desc[0]));
            
            if(!map.containsKey(desc[1]))
                map.put(desc[1], new TreeNode(desc[1]));

            if(desc[2] == 1){
                map.get(desc[0]).left = map.get(desc[1]);
            }
            else{
                map.get(desc[0]).right = map.get(desc[1]);
            }
        }  
        int child = 0;
        for(Integer parent:map.keySet()){
            if(!childs.contains(parent))
                child = parent;
        }
        return map.get(child);
    }

}
