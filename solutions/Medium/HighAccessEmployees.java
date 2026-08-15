/**
 * LeetCode #3202 - High-Access Employees
 * Difficulty : Medium
 * Topics     : Array, Hash Table, String, Sorting
 * Date       : 2026-08-15
 * URL        : https://leetcode.com/problems/high-access-employees/
 */

class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(List<String> access : access_times){
            if(map.containsKey(access.get(0))){
                map.get(access.get(0)).add(convertToInt(access.get(1)));
            }
            else
            {
                List<Integer> list = new ArrayList<>();
                list.add(convertToInt(access.get(1)));
                map.put(access.get(0), list);
            }
        }

        List<String> res = new ArrayList<>();
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() < 3)
                continue;
            
            List<Integer> accessTimeList = entry.getValue();
            accessTimeList.sort(null);
            int j = 2;
            while(j<accessTimeList.size()){
                if(Math.abs(accessTimeList.get(j) - accessTimeList.get(j-2)) < 60){
                    res.add(entry.getKey());
                    break;
                }
                j++;
            }
        }
        return res;
    }
    public int convertToInt(String time){
        return (Integer.parseInt( time.substring(0,2) ) * 60) + (Integer.parseInt(time.substring(2))); 
    }
}
