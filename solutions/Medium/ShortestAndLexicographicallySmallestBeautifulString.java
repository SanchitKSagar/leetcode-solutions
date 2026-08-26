/**
 * LeetCode #3150 - Shortest and Lexicographically Smallest Beautiful String
 * Difficulty : Medium
 * Topics     : String, Sliding Window
 * Date       : 2026-08-26
 * URL        : https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/
 */

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i =0, j=0;
        int count = 0;
        List<String> list = new ArrayList<>();
        while(j<s.length()){
            if(s.charAt(j) == '1'){
                count++;
            }
            
            if(count == k){
                list.add(s.substring(i,j+1));
            }
            if(count <= k){
            }
            else{
                while(i<j && count >= k){
                    if(s.charAt(i) == '1')
                        count--;
                    i++;
                    if(count == k){
                        list.add(s.substring(i,j+1));
                    }
                }
            }
            j++;
        }
        Comparator<String> comp1 = (a,b) -> a.length()-b.length();
        Comparator<String> comp2 = (a,b) -> a.compareTo(b);
        
        List<String> res =  list.stream().map(str -> {
            int idx = 0;
            while(str.charAt(idx) != '1'){
                idx++;
            }
            return str.substring(idx);
        })
        .sorted(comp1.thenComparing(comp2))
        .collect(Collectors.toList());
        //res.sort(null);
        //System.out.println("--" +res);
        return res == null || res.size() == 0 ? "" :res.get(0);
    }
}
