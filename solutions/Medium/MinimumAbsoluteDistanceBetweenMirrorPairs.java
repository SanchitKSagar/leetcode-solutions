/**
 * LeetCode #4139 - Minimum Absolute Distance Between Mirror Pairs
 * Difficulty : Medium
 * Topics     : Array, Hash Table, Math
 * Date       : 2026-04-17
 * URL        : https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/
 */

class Solution {

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> prev = new HashMap<>();
        int n = nums.length;
        int ans = n + 1;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (prev.containsKey(x)) {
                ans = Math.min(ans, i - prev.get(x));
            }
            prev.put(reverseNum(x), i);
        }

        return ans == n + 1 ? -1 : ans;
    }

    private int reverseNum(int x) {
        return Integer.valueOf(new StringBuilder("" + x).reverse().toString());
    }
}
