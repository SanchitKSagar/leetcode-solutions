/**
 * LeetCode #2215 - Finding 3-Digit Even Numbers
 * Difficulty : Easy
 * Topics     : Array, Hash Table, Recursion, Sorting, Enumeration
 * Date       : 2026-07-29
 * URL        : https://leetcode.com/problems/finding-3-digit-even-numbers/
 */

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> list = new HashSet<>();
        for(int i=0;i<digits.length;i++){
            for(int j=0;j<digits.length;j++){
                for(int k=0;k<digits.length;k++){
                    if(i!=j && k !=i && k != j){
                        int n = digits[k] + (digits[j] * 10) + (digits[i] * 100);
                        if(String.valueOf(n).length() == 3 && n%2 == 0)
                            list.add(n); 
                    }
                }
            }
        }
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
