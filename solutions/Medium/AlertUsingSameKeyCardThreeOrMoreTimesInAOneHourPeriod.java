/**
 * LeetCode #1709 - Alert Using Same Key-Card Three or More Times in a One Hour Period
 * Difficulty : Medium
 * Topics     : Array, Hash Table, String, Sorting
 * Date       : 2026-08-15
 * URL        : https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
 */

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0;i<keyName.length;i++){
            if(map.containsKey(keyName[i])){
                map.get(keyName[i]).add(getInttime(keyTime[i]));
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(getInttime(keyTime[i]));
                map.put(keyName[i], list);
            }
        }
        List<String> res = new ArrayList<>();
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() < 3)
                continue;
            List<Integer> list = entry.getValue();
            list.sort(null);
            int j = 2;
            while(j < list.size()){
                if(Math.abs(list.get(j) - list.get(j-2)) <= 60 ){
                    res.add(entry.getKey());
                    break;
                }
                j++;
            }
        }
        res.sort(null);
        return res;
    }
    public int getInttime(String time){
        int res = 0;
        String[] sp = time.split(":");
        res += Integer.parseInt(sp[0]) * 60 + Integer.parseInt(sp[1]);
        return res;
    }   
}
