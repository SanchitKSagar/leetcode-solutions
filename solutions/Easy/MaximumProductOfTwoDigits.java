/**
 * LeetCode #3859 - Maximum Product of Two Digits
 * Difficulty : Easy
 * Topics     : Math, Sorting
 * Date       : 2026-07-25
 * URL        : https://leetcode.com/problems/maximum-product-of-two-digits/
 */

class Solution {
    public int maxProduct(int n) {
        int[] sn = String.valueOf(n)
            .chars()
            .mapToObj(e -> e-'0')
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
        // List<Integer> l = new ArrayList<>();
        // while(n!=0){
        //     l.add(n%10);
        //     n/ = 10;
        // }
        // l.sort(null);

        return sn[sn.length-1] * sn[sn.length-2];
    }
}
