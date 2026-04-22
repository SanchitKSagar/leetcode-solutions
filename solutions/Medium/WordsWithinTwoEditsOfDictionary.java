/**
 * LeetCode #2550 - Words Within Two Edits of Dictionary
 * Difficulty : Medium
 * Topics     : Array, String, Trie
 * Date       : 2026-04-22
 * URL        : https://leetcode.com/problems/words-within-two-edits-of-dictionary/
 */

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for(String query : queries){
            if(canMakein2Edit(query, dictionary))
                res.add(query);
        }
        return res;
    }
    public boolean canMakein2Edit(String query, String[] dict){
        for(String d:dict){
            int count = 0;
            for(int i=0;i<d.length();i++){
                if(d.charAt(i) != query.charAt(i))
                    count++;
                if(count > 2){
                    break;
                }
            }
            if(count <= 2)
                return true;
        }
        return false;
    }
}
