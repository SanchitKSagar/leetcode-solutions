/**
 * LeetCode #2846 - Robot Collisions
 * Difficulty : Hard
 * Topics     : Array, Stack, Sorting, Simulation
 * Date       : 2026-04-01
 * URL        : https://leetcode.com/problems/robot-collisions/
 */

class Solution {
    class Node{
        int pos;
        int h;
        boolean isMovingRight;
        boolean survived;
        Node(int pos, int h, boolean isMovingRight, boolean survived){
            this.pos = pos;
            this.h = h;
            this.isMovingRight = isMovingRight;
            this.survived = survived;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        // List<Node> movingRight = new ArrayList<Node>();
        List<Node> movingArray = new ArrayList<Node>();
        Map<Integer, Node> map= new HashMap<>();
        for(int i=0;i<positions.length;i++){
            Node nn = new Node(positions[i], healths[i], directions.charAt(i) == 'R', true);
            // if(directions.charAt(i) == 'R'){
            //     movingRight.add(nn);
            // }
            // else
            // {
            //     movingLeft.add(nn);
            // }
            movingArray.add(nn);
            map.put(i, nn);
        }
        movingArray.sort((a,b) -> a.pos-b.pos);
        // movingRight.sort((a,b) ->a.h-b.h));
        // movingLeft.sort((a,b) ->a.h-b.h);

        Stack<Node> stackToRight = new Stack<>();
        
        for(int i=0;i<movingArray.size();i++){
            if(movingArray.get(i).isMovingRight){
                stackToRight.push(movingArray.get(i));
            }
            else
            {
                // if(stackToRight.peek().h == movingArray.get(i).h){
                //     Node n = stackToRight.pop();
                //     n.h = 0;
                //     movingArray.get(i).h = 0;
                //     continue;
                // }
                while(!stackToRight.isEmpty() && stackToRight.peek().h < movingArray.get(i).h){
                    Node n = stackToRight.pop();
                    n.h = 0;
                    n.survived = false;
                    movingArray.get(i).h = movingArray.get(i).h - 1;
                }
                if(!stackToRight.isEmpty()){
                    if(stackToRight.peek().h == movingArray.get(i).h){
                        Node n = stackToRight.pop();
                        n.h = 0;
                        n.survived = false;
                        movingArray.get(i).h = 0;
                        movingArray.get(i).survived = false;
                        continue;
                    }
                    movingArray.get(i).h = 0;
                    movingArray.get(i).survived = false;
                    Node node = stackToRight.pop();
                    node.h = node.h - 1;
                    stackToRight.push(node);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<positions.length;i++){
            if(map.get(i).survived){
                res.add(map.get(i).h);
            }
        }

        return res;
    }
}
