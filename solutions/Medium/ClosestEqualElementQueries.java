/**
 * LeetCode #3750 - Closest Equal Element Queries
 * Difficulty : Medium
 * Topics     : Array, Hash Table, Binary Search
 * Date       : 2026-04-16
 * URL        : https://leetcode.com/problems/closest-equal-element-queries/
 */

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map =new HashMap<>();
        List<Integer> res = new ArrayList<>(); 
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.get(nums[i]).add(i);
            else{
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(nums[i], l);
            }
        }
       // int counter = 0;
        for(int queryIdx : queries){
            int min = Integer.MAX_VALUE;
            int val = nums[queryIdx];
            if(!map.containsKey(val) || map.get(val).size() == 1){
                res.add(-1);
                continue;
            }

            // List<Integer> l = new ArrayList<>(map.get(val));
            List<Integer> l = map.get(val);
            int idx = Collections.binarySearch(map.get(val), queryIdx);

            if(idx == 0){
                min = Math.min(min, l.get(idx+1) - l.get(idx));
                min = Math.min(min, nums.length - l.get(l.size()-1) + l.get(idx));
                
            }
            else if(idx == l.size()-1){
                min = Math.min(min, l.get(idx) - l.get(idx-1));
                min = Math.min(min, nums.length - l.get(idx) + l.get(0));
            }
            else{
                min = Math.min(min, l.get(idx+1) - l.get(idx));
                min = Math.min(min, l.get(idx) - l.get(idx-1));
            }
            // for(int i=0;i<map.get(val).size();i++){
            //     int idx = map.get(val).get(i);
            //     if(idx != queryIdx){
            //         //System.out.println("" + i + " " + qu)
                    // if( idx > queryIdx ){
                    //     min = Math.min(min, idx-queryIdx);
                    //     min = Math.min(min, nums.length - idx + queryIdx);
                    // }
                    // else{
                    //     min = Math.min(min, queryIdx - idx);
                    //     min = Math.min(min, idx + nums.length - queryIdx);
                    // }
            //     }
            // }
            res.add(min);
        }
        return res;
    }

    // public int getIndex(List<Integer> list, int val){

    //     int l = 0;
    //     int r = list.size()-1;
    //     while(l <= r){
    //         int mid = l + (r-l)/2;
    //         if(list.get(mid) == val)
    //             return mid;
    //         else if(list.get(mid) > val){
    //             r = mid -1;
    //         }
    //         else
    //             l = mid+1;
    //     }
    //     return -1;
    // }
}
