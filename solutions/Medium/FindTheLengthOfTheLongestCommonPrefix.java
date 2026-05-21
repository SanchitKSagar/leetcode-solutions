/**
 * LeetCode #3329 - Find the Length of the Longest Common Prefix
 * Difficulty : Medium
 * Topics     : Array, Hash Table, String, Trie
 * Date       : 2026-05-21
 * URL        : https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/
 */

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> set = new HashSet<>();
        for(int num : arr1){
            String s = String.valueOf(num);
            
            StringBuilder ss = new StringBuilder();
            for(char c:s.toCharArray())
                set.add(ss.append(c).toString());
        }
        int res = 0;
        for(int num:arr2){
            String s = String.valueOf(num);
            int i=0;
            int count = 0;
            StringBuilder ss = new StringBuilder();

            while(i<s.length()){
                ss.append(s.charAt(i));
                if(set.contains(ss.toString()))
                    count ++;
                else
                    break;
                i++;
            }
            res = Math.max(res, count);
        }

        return res;
    }
}
