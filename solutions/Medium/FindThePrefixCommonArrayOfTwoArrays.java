/**
 * LeetCode #2766 - Find the Prefix Common Array of Two Arrays
 * Difficulty : Medium
 * Topics     : Array, Hash Table, Bit Manipulation
 * Date       : 2026-05-20
 * URL        : https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
 */

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        if(A.length == 0 || B.length ==0)
            return new int[] {};
        int[] res = new int[A.length];

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(A[0]);
        set2.add(B[0]);
        if(A[0] == B[0])
            res[0] = 1;
        int c = 0;
        for(int i=1;i<A.length;i++){
            set1.add(A[i]);
            set2.add(B[i]);
            c=0;
            if(A[i] == B[i])
                c=1;
            else{
                if(set1.contains(B[i]))
                    c +=1;
                if(set2.contains(A[i]))
                    c+=1;
            }
            res[i] = res[i-1] + c;
        }
        return res;
    }
}
