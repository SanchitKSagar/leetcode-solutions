/**
 * LeetCode #2178 - Walking Robot Simulation II
 * Difficulty : Medium
 * Topics     : Design, Simulation
 * Date       : 2026-04-07
 * URL        : https://leetcode.com/problems/walking-robot-simulation-ii/
 */

/*
class Robot {
    int currX;
	    int currY;
	    char[][] grid;
	    char[] dir = new char[] {'E','N','W','S'};

	    public Robot(int width, int height) {
	        grid = new char[height][width];
	        currX = height-1;
	        currY = 0;
	        grid[currX][currY] = 'E';
	    }
	    
	    public void step(int num) {
	        int width = grid[0].length;
	        int height = grid.length;
	        switch (grid[currX][currY]) {
	            case 'E':   
	                        if(currY + num >= width){
	                            int temp = currY + num;
	                            currY = width-1;
	                            grid[currX][currY] = 'N';
	                            step(Math.abs(temp - currY)); 
	                        }
	                        else{
	                            currY += num;
	                                grid[currX][currY] = 'E';
	                        }
	                        break;
	            case 'N':
	                        if(currX - num < 0){
	                            int temp = currX - num;
	                            currX = 0;
	                            grid[currX][currY] = 'W';
	                            step(Math.abs(temp));
	                        }
	                        else{
	                            currX -= num;
	                                grid[currX][currY] = 'N';
	                        }
	                        break;
	            case 'W':
	            			if(currY - num < 0) {
	            				int temp = currY - num;
	            				currY = 0;
	            				grid[currX][currY] = 'S';
	            				step(Math.abs(temp));
	            			}
	            			else {
	            				currY -= num;
	            					grid[currX][currY] = 'W';
	            			}
	            			break;
	            case 'S':
	            			if(currX + num >= height) {
	            				int temp = currX + num;
	            				currX = height-1;
	            				grid[currX][currY] = 'E';
	            				step(Math.abs(temp - currX));
	            			}
	            			else {
	            				currX += num;
	            					grid[currX][currY] = 'S';
	            			}
	            			break;
	            default:
	            			break;
	        }
	    }
	    
	    public int[] getPos() {
	        return new int[]{currY, grid.length-1-currX};
	    }
	    
	    public String getDir() {
	        switch (grid[currX][currY]) {
        	case 'N': return "North";
        	case 'S': return "South";
        	case 'E': return "East";
        	case 'W': return "West";
        	default: break;
	        }
	        return null;
	    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
*/


class Robot {
    List<int[]> grid ;
    int pos;
    boolean isChanged = false;
    public Robot(int width, int height) {
        grid = new ArrayList<>();
        grid.add(new int[]{0,0,3});
        for(int i=1;i<width;i++)
            grid.add(new int[]{i, 0, 0});
        for(int y=1;y<height;y++)
            grid.add(new int[]{width-1, y, 1});
        for(int x=width-2;x>=0;x--)
            grid.add(new int[]{x, height-1, 2});
        for(int y=height-2;y>0;y--)
            grid.add(new int[]{0, y, 3});
        pos = 0;
        isChanged = false;
        //disp(grid);
    }
    public void disp(List<int[]> g){
        for(int[] i: g){
            System.out.println("" + i[0] + " " + i[1] + " " + i[1]);
        }
    }
    
    public void step(int num) {
        pos += num ;
        isChanged = true;
    }
    
    public int[] getPos() {
        int[] res = grid.get(pos%grid.size());
        return new int[] {res[0], res[1]};
    }
    
    public String getDir() {
        if(pos% grid.size() == 0){
            if(!isChanged)
                return "East";
            else
                return "South";
        }
        switch (grid.get(pos% grid.size())[2]){
            case 0: return "East";
            case 1: return "North";
            case 2: return "West";
            case 3: return "South";
            default: break;
        }
        return null;
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
