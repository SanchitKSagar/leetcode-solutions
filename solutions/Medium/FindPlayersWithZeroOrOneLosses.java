/**
 * LeetCode #1354 - Find Players With Zero or One Losses
 * Difficulty : Medium
 * Topics     : Array, Hash Table, Sorting, Counting
 * Date       : 2026-08-15
 * URL        : https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 */

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> allPlayers = new HashSet<>();
        for(int[] match:matches){
            allPlayers.add(match[0]);
            allPlayers.add(match[1]);
        }


        Map<Integer, Integer> losses = new HashMap<>();
        for(int[] match:matches){
            allPlayers.remove(match[1]);
            losses.put(match[1], losses.getOrDefault(match[1], 0)+1);
        }
        List<List<Integer>> res = new ArrayList<>();
        System.out.println(allPlayers);
        System.out.println(losses);
        List<Integer> lossesZero = new ArrayList<>();
        List<Integer> lossesOnce = new ArrayList<>();
        for(int all:allPlayers)
            lossesZero.add(all);
        for(Map.Entry<Integer, Integer> entry : losses.entrySet()){
            if(entry.getValue() == 1)
                lossesOnce.add(entry.getKey());
        }
        lossesZero.sort(null);
        lossesOnce.sort(null);
        res.add(lossesZero);
        res.add(lossesOnce);

        return res;
    }
}
