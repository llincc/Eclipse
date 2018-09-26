package insert_interval;

import java.util.ArrayList;

/*ÌâÄ¿ÃèÊö

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1: 
Given intervals[1,3],[6,9], insert and merge[2,5]in as[1,5],[6,9].

Example 2: 
Given[1,2],[3,5],[6,7],[8,10],[12,16], insert and merge[4,9]in as[1,2],[3,10],[12,16].

This is because the new interval[4,9]overlaps with[3,5],[6,7],[8,10].

*/
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals.isEmpty()) {
        	result.add(newInterval);
        	return result;
        }
        int start = newInterval.start;
        int end = newInterval.end;
        
        boolean isAdd = false;
        for(int i=0; i<intervals.size(); i++){
        	Interval interval = intervals.get(i);
        	if(interval.end < start){
        		result.add(interval);
        		continue;
        	}
        	if(interval.start > end){
        		if(!isAdd){
            		result.add(new Interval(start, end));
            		isAdd = true;	
        		}
        		result.add(interval);
        		continue;
        	}
        	if(start>=interval.start && start <= interval.end){
        		start = interval.start;
        	}
        	if(end >= interval.start && end <= interval.end){
        		end = interval.end;
        	}
        }
        if(isAdd){
        	result.add(new Interval(start, end));
        }
        
        return result;
    }
}
