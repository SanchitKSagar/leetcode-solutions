/**
 * LeetCode #3844 - Number of Ways to Assign Edge Weights I
 * Difficulty : Medium
 * Topics     : Math, Tree, Depth-First Search
 * Date       : 2026-06-11
 * URL        : https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/
 */

class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int MOD = 1000000007;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge:edges){
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int depth = getMaxDepth(map, 1, new HashSet<Integer>());
        //System.out.println(depth);
        depth = depth-1;
        int res = 1;
        while(depth != 1){
            res = (res * 2) % MOD;
            depth -- ;
        }
        return res;
    }
    public int getMaxDepth(Map<Integer, List<Integer>> map, int curr, Set<Integer> visited){
        if(visited.contains(curr))
            return 0;
        visited.add(curr);
        int max = 0;
        for(int l:map.get(curr)){
            max = Math.max(max, getMaxDepth(map, l, visited));
        }
        return 1+max;
    }
}
