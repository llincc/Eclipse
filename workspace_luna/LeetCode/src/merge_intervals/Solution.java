package merge_intervals;

import java.util.ArrayList;
import java.util.Comparator;

/*ÌâÄ¿ÃèÊö

Given a collection of intervals, merge all overlapping intervals.

For example,
Given[1,3],[2,6],[8,10],[15,18],
return[1,6],[8,10],[15,18].*/
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
	Comparator<Interval> cmp = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			if(o1.start > o2.start) return 1;
			else return -1;			
		}
	};
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals.size()<= 1) return intervals;
        ArrayList<Interval> result = new ArrayList<Interval>();
        intervals.sort(cmp);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i=1; i<intervals.size(); i++){
        	Interval interval = intervals.get(i);
        	if(interval.start>end){
        		result.add(new Interval(start,end));
        		start = interval.start;
        		end = interval.end;
        		continue;
        	}
        	if(interval.start <= start && start<=interval.end) start = interval.start;
        	if(interval.start <= end   && end <= interval.end) end = interval.end;
        }
        result.add(new Interval(start, end));
        return result;
    }
    
    public static void main(String[] args) {
    	Comparator<Interval> cmp = new Comparator<Interval>() {

    		@Override
    		public int compare(Interval o1, Interval o2) {
    			// TODO Auto-generated method stub
    			if(o1.start > o2.start) return 1;
    			else return -1;			
    		}
    	};
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(0, 1));
		intervals.sort(cmp);
	}
}
