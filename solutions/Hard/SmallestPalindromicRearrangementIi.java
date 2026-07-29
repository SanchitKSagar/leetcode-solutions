/**
 * LeetCode #3813 - Smallest Palindromic Rearrangement II
 * Difficulty : Hard
 * Topics     : Hash Table, Math, String, Combinatorics, Counting
 * Date       : 2026-07-29
 * URL        : https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/
 */

// class Solution {
//     public String smallestPalindrome(String s, int k) {
//         int[] freq = new int[26];
//         for(char ch:s.toCharArray())
//             freq[ch-'a']++;
//         String res = "";
//         for(int i=0;i<26;i++){
//             if(freq[i] % 2 == 0){
//                 res += String.valueOf((char)('a'+i)).repeat(freq[i]/2);
//                 freq[i] = 0;
//             }
//             else
//             {
//                 res += String.valueOf((char)('a'+i)).repeat(freq[i]/2);
//                 freq[i] = 1;
//             }
//         }
//         StringBuilder r = new StringBuilder(res);
//         for(int i=0;i<26;i++){
//             if(freq[i] == 1){
//                 res += (char)('a'+i);
//                 break;
//             }
//         }

//         return res + r.reverse();
//     }

//     public String getKth(String str, int[] freq, int k){
//         String res = "";
//         int n = str.length();
//         while(n!=0){

//             for(int i=0;i<26;i++){
//                 int getMaxFreqNotI = getMaxFreqNotI(i, freq);
//                 int ways = countWays(n-1, getMaxFreqNotI);
//                 if(ways >=k){
//                     res += (char)('a'+i);
//                     freq[i]--;
//                     break;
//                 }
//                 k -= ways;
//             }
//             n--;
//         }
//         return res;
//     }
//     public int getMaxFreqNotI(int i, int[] freq){
//         int max = 0;
//         for(int j=0;j<26;j++){
//             if(j!=i){
//                 max = Math.max(max, freq[j]);
//             }
//         }
//         return max;
//     }
//     public int countWays(int n, int r){
//         int res = 1;
//         while(n!=r){
//             res *= n;
//             n--;
//         }
//         return res;
//     }
// }

class Solution {

    private long comb(long n, long m, long k) {
        long res = 1;
        m = Math.min(m, n - m);

        for (long i = 1; i <= m; i++) {
            res = (res * (n - i + 1)) / i;
            if (res > k) {
                return k + 1;
            }
        }
        return res;
    }

    private long permutations(int rem, int[] bucket, long k) {
        long ways = 1;
        for (int i = 0; i < 26; i++) {
            if (bucket[i] == 0) {
                continue;
            }

            ways *= comb(rem, bucket[i], k);
            if (ways > k) {
                break;
            }
            rem -= bucket[i];
        }
        return ways;
    }

    public String smallestPalindrome(String s, long k) {
        int partition = s.length() / 2;
        int[] bucket = new int[26];

        for (int i = 0; i < partition; i++) {
            bucket[s.charAt(i) - 97] += 1;
        }

        StringBuilder left = new StringBuilder();
        long startIndex = 1;

        for (int pos = 0; pos < partition; pos++) {
            for (int i = 0; i < 26; i++) {
                if (bucket[i] == 0) {
                    continue;
                }

                bucket[i] -= 1;

                long ways = permutations(partition - pos - 1, bucket, k);
                if (startIndex + ways > k) {
                    left.append((char) (i + 97));
                    break;
                }

                bucket[i] += 1;
                startIndex += ways;
            }
        }

        if (left.length() < partition) {
            return "";
        }

        if (s.length() % 2 != 0) {
            left.append(s.charAt(partition));
        }

        for (int i = partition - 1; i >= 0; i--) {
            left.append(left.charAt(i));
        }

        return left.toString();
    }
}
