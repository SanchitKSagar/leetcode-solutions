/**
 * LeetCode #4216 - Weighted Word Mapping
 * Difficulty : Easy
 * Topics     : Array, String, Simulation
 * Date       : 2026-06-13
 * URL        : https://leetcode.com/problems/weighted-word-mapping/
 */

class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder();
        int sum = 0;
        for(String word:words){
            sum = 0;
            for(char ch : word.toCharArray())
                sum += weights[(int)(ch-'a')];
            res.append((char)('z' - (sum % 26)));
        }

        return res.toString();
    }
}
