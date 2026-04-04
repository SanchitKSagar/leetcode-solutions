/**
 * LeetCode #2197 - Decode the Slanted Ciphertext
 * Difficulty : Medium
 * Topics     : String, Simulation
 * Date       : 2026-04-04
 * URL        : https://leetcode.com/problems/decode-the-slanted-ciphertext/
 */

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1)
            return encodedText;

        int n = encodedText.length();
        int cols = n / rows;

        StringBuilder res = new StringBuilder(n);

        for (int c = 0; c < cols; c++) {
            int r = 0, j = c;
            while (r < rows && j < cols) {
                res.append(encodedText.charAt(r * cols + j));
                r++;
                j++;
            }
        }

        int end = res.length() - 1;
        while (end >= 0 && res.charAt(end) == ' ') {
            end--;
        }

        return res.substring(0, end + 1);
    }
}
