/**
 * LeetCode #4119 - Minimum Distance Between Three Equal Elements II
 * Difficulty : Medium
 * Topics     : Array, Hash Table
 * Date       : 2026-04-11
 * URL        : https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/
 */

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.get(nums[i]).offer(i);
            else {
                Queue<Integer> q = new PriorityQueue<>((a,b) -> a-b);
                q.offer(i);
                map.put(nums[i], q);
            }
        }
        for(Map.Entry<Integer, Queue<Integer>> entry: map.entrySet()){
            if(entry.getValue().size() >= 3){
                Queue<Integer> q= entry.getValue();
                int a = q.poll();
                int b = q.poll();
                int c = q.poll();
                min = Math.min(min, Math.abs(a-b) + Math.abs(b-c) + Math.abs(c-a));
                while(!q.isEmpty()){
                    min = Math.min(min, Math.abs(a-b) + Math.abs(b-c) + Math.abs(c-a));
                    a=b;
                    b=c;
                    c = q.poll();
                }
                min = Math.min(min, Math.abs(a-b) + Math.abs(b-c) + Math.abs(c-a));
            }
        }
        
        return min == Integer.MAX_VALUE ? -1:min;
    }
}
