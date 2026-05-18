/**
 * LeetCode #1447 - Jump Game IV
 * Difficulty : Hard
 * Topics     : Array, Hash Table, Breadth-First Search
 * Date       : 2026-05-18
 * URL        : https://leetcode.com/problems/jump-game-iv/
 */

class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]))
                map.get(arr[i]).add(i);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        q.offer(0);
        visited[0] = true;
        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();
            count++;

            for(int i=0;i<size;i++){
                int idx = q.poll();
                List<Integer> list = new ArrayList<>(map.get(arr[idx]));
                list.add(idx+1);
                list.add(idx-1);

                for(int l:list){
                    if(l<0 || l>= arr.length || visited[l])
                        continue;
                    if(l == arr.length-1)
                        return count;
                    visited[l] = true;
                    q.offer(l);
                }

                map.get(arr[idx]).clear();
            }
        }

        return 0;
    }

   
}
