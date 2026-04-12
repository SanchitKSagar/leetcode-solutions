/**
 * LeetCode #1443 - Minimum Distance to Type a Word Using Two Fingers
 * Difficulty : Hard
 * Topics     : String, Dynamic Programming
 * Date       : 2026-04-12
 * URL        : https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/
 */

class Solution {
    Map<Character, int[]> map;
    Map<String, Integer> dp;
    public int minimumDistance(String word) {
        map = new HashMap<>();
        dp = new HashMap<>();
        for(int i=0;i<26;i++){
            map.put((char)((int)'A' + i ), new int[]{i/6,i%6});
        }
        return helper(0, '\0', '\0', word);
    }

    public int helper(int idx, char f1, char f2, String word){
        if(idx == word.length())
            return 0;
        if(dp.containsKey(idx+ "" + f1 + "" + f2))
            return dp.get(idx+ "" + f1 + "" + f2);

        int c1 = dist(f1, word.charAt(idx)) + helper(idx+1, word.charAt(idx), f2, word);
        int c2 = dist(f2, word.charAt(idx)) + helper(idx+1, f1, word.charAt(idx), word);
        dp.put(idx+ "" + f1 + "" + f2, Math.min(c1,c2));
        return Math.min(c1,c2);
    }

    public int dist(char f1, char letter){
        if(f1 == '\0')
            return 0;
        int[] f1c = map.get(f1);
        int[] lc = map.get(letter);

        return Math.abs(f1c[0] - lc[0]) + Math.abs(f1c[1] - lc[1]);

    }
}
