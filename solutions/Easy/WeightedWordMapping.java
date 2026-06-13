/**
 * LeetCode #4216 - Weighted Word Mapping
 * Difficulty : Easy
 * Topics     : Array, String, Simulation
 * Date       : 2026-06-13
 * URL        : https://leetcode.com/problems/weighted-word-mapping/
 */

class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        Map<Integer, Character> map = new HashMap<>();
        String res = "";
        for(int i=0;i<26;i++){
            map.put(i, (char)('z' - i));
        }    

        int sum = 0;
        for(String word:words){
            sum = 0;
            for(char ch : word.toCharArray())
                sum += weights[(int)(ch-'a')];
            //System.out.println(map + " " + sum + " " + sum%26 + " " + map.get(sum % 26));
            res += map.get(sum % 26);
        }

        return res;
    }
}
