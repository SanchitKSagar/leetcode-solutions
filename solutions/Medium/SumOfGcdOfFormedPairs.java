/**
 * LeetCode #4242 - Sum of GCD of Formed Pairs
 * Difficulty : Medium
 * Topics     : Array, Math, Two Pointers, Sorting, Simulation, Number Theory
 * Date       : 2026-07-16
 * URL        : https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/
 */

class Solution {
    public long gcdSum(int[] nums) {
        int[] max = new int[nums.length];
        max[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            max[i] = Math.max(max[i-1], nums[i]);
        }

        int[] prefixGcd = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            prefixGcd[i] = gcd(nums[i], max[i]);
        }

        Arrays.sort(prefixGcd);
        long ans = 0;
        int l = 0, r = nums.length-1;

        while(l<r){
            ans += gcd(prefixGcd[l], prefixGcd[r]);
            l++;
            r--;
        }
        return ans;
        
    }

    public int gcd(int n1, int n2){
        while(n2!=0){
            int temp = n1;
            n1 = n2;
            n2 = temp % n2;
        }
        return n1;
    }
}
