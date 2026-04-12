/**
 * LeetCode #4266 - Angles of a Triangle
 * Difficulty : Medium
 * Topics     : 
 * Date       : 2026-04-12
 * URL        : https://leetcode.com/problems/angles-of-a-triangle/
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

class Solution {
    public double[] internalAngles(int[] sides) {
        Arrays.sort(sides);
        if(sides[0] + sides[1] <= sides[2])
            return new double[]{};
        
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];
        double[] res= new double[3];
        BigDecimal a1 = new BigDecimal(Math.acos((double)((a*a) + (b*b) - (c*c))/ (2 * a*b) ) * (180/Math.PI));
        BigDecimal a2 = new BigDecimal( Math.acos((double)((b*b) + (c*c) - (a*a))/ (2 * c*b) )* (180/Math.PI)) ;
        BigDecimal a3 = new BigDecimal( Math.acos((double)((a*a) + (c*c) - (b*b))/ (2 * a*c) )* (180/Math.PI)) ;
        res[2] = a1.setScale(5, RoundingMode.HALF_UP).doubleValue();
        res[0] = a2.setScale(5, RoundingMode.HALF_UP).doubleValue();
        res[1] = a3.setScale(5, RoundingMode.HALF_UP).doubleValue();
        return res;
    }
}
