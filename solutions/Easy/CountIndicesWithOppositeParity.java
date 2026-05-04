/**
 * LeetCode #4295 - Count Indices With Opposite Parity
 * Difficulty : Easy
 * Topics     : 
 * Date       : 2026-05-04
 * URL        : https://leetcode.com/problems/count-indices-with-opposite-parity/
 */

class Solution {
    public int[] countOppositeParity(int[] nums) {
        int[] even = new int[nums.length];
        int[] odd = new int[nums.length];

        even[nums.length-1] = 0;
        odd[nums.length-1] = 0;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i+1] % 2 == 0){
                even[i] = even[i+1] +1;
                odd[i] = odd[i+1];
            }
            else{
                odd[i] = odd[i+1] + 1;
                even[i] = even[i+1];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] % 2 ==0)
                nums[i] = odd[i];
            else
                nums[i] = even[i];
        }
        return nums;
    }
}
