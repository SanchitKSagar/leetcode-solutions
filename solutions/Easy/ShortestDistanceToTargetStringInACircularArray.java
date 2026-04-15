/**
 * LeetCode #2598 - Shortest Distance to Target String in a Circular Array
 * Difficulty : Easy
 * Topics     : Array, String
 * Date       : 2026-04-15
 * URL        : https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/
 */

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        Map<String, List<Integer>> map = new HashMap<>();
        int n = words.length;
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i]))
                map.get(words[i]).add(i);
            else{
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(words[i], l);
            }
        }

        if(!map.containsKey(target))
            return -1;
        int min = Integer.MAX_VALUE;
        for(int idx : map.get(target)){
            if(idx > startIndex){
                min = Math.min(min, idx - startIndex);
                min = Math.min(min, n - idx + startIndex); 
            }
            else
            {
                min = Math.min(min, startIndex - idx);
                min = Math.min(min, n - startIndex + idx);
            }
        }
        return min;
    }
}
