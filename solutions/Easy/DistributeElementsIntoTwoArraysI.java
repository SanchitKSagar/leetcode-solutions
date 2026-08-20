/**
 * LeetCode #3347 - Distribute Elements Into Two Arrays I
 * Difficulty : Easy
 * Topics     : Array, Simulation
 * Date       : 2026-08-20
 * URL        : https://leetcode.com/problems/distribute-elements-into-two-arrays-i/
 */

class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        int last1 = nums[0];
        arr2.add(nums[1]);
        int last2 = nums[1]; 

        for(int i=2;i<nums.length;i++){
            if(last1 > last2){
                arr1.add(nums[i]);
                last1 = nums[i];
            }
            else
            {
                arr2.add(nums[i]);
                last2 = nums[i];
            }
        }
        arr1.addAll(arr2);
        return arr1.stream().mapToInt(Integer::intValue).toArray();

    }
}
