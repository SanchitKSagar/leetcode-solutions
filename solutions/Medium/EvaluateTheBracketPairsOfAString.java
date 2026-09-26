/**
 * LeetCode #1934 - Evaluate the Bracket Pairs of a String
 * Difficulty : Medium
 * Topics     : Array, Hash Table, String
 * Date       : 2026-09-26
 * URL        : https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
 */

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(List<String> k:knowledge){
            map.put(k.get(0), k.get(1));
        }

        String key = "";
        StringBuilder sb = new StringBuilder();
        boolean isOpenFound = false;
        for(char ch:s.toCharArray()){
            if(ch == '('){
                isOpenFound = true;
                key = "";
                continue;
            }
            if(ch == ')'){
                isOpenFound = false;
                if(map.containsKey(key))
                    sb.append(map.get(key));
                else
                    sb.append("?");
                continue;
            }
            if(isOpenFound){
                key += ch;
            }
            else
            {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
