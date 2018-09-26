package max_points_on_a_line;

import java.util.HashMap;
import java.util.Map;


 //Definition for a point.
//找点最多的直线的点的个数
class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
}
 
public class Solution {
    public int maxPoints(Point[] points) {
        
        if(points.length<=2) return points.length;
        
  
        int maxpoint = 0;
        for(int i=0; i<points.length; i++){
        	Point pa = points[i];
        	int dup = 1, vtl = 0;
        	Map<Float, Integer> slopeMap = new HashMap<Float, Integer>();
        	for(int j=0; j<points.length; j++){
        		if(i == j) continue;
        		
    			Point pb = points[j];
    		    
    		    if(pa.x == pb.x){
    		    	if(pa.y == pb.y) dup++;
    		    	else vtl++;
    		    }
    		    else{
    		    	
        		    float slopeab = (float)(pa.y - pb.y)/(float)(pa.x - pb.x);
        		    if(slopeMap.get(slopeab)==null) slopeMap.put(slopeab, 1);
        		    else slopeMap.put(slopeab, slopeMap.get(slopeab)+1);
    		    }
        		
        	}
        	int max = vtl;
            for(Integer num: slopeMap.values()){
            	max = max > num ? max : num;
            }
            maxpoint = Math.max(maxpoint, max + dup);
        }

        return maxpoint;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
		Point[] points = {new Point(0,0),new Point(14,6),new Point(8,12),new Point(2,4)};
		System.out.println(solution.maxPoints(points)); 
	} 
}
