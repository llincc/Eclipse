package candy;

import java.util.Arrays;

public class Solution {
/*	There are N children standing in a line. Each child is assigned a rating value.

	You are giving candies to these children subjected to the following requirements:

	Each child must have at least one candy.
	Children with a higher rating get more candies than their neighbors.
	What is the minimum candies you must give?*/

    //找坡顶/坡底
//    public int candy(int[] ratings) {
//        int total = 0;
//        int pre = 0;
//        int preR = 0;
//        int start = 0;    //坡的开始位置
//        int end = 0;      //坡的结束位置
//        
//        int top_start = 0; //坡顶（底）的开始位置（因为坡顶或底可能是连续的数）
//        int top_end = 0;   //坡顶（底）的结束位置，为下一个坡的开始位置
//        int flag = 0;
//        // 2222->1111, 1221->1221, 12221->12121, 12331->12321, 432213->321212, 1223->1212, 12223->12112, 433221->212121 
//        for(int i=0; i<ratings.length; ){
//        	if(flag == 0){  //爬坡
////        		System.out.println("爬坡。。。。。。");
//        		pre = 1;    //每次爬坡都是从1开始
//        		start = i;  //坡的开始位置
//        		end = i;    //坡的结束位置
//        		preR = ratings[i++];
//            	while(i<ratings.length && preR < ratings[i]){ //找到坡的结束位置
//	        		end++;
//	        		preR = ratings[i++];
//        	    }
//            	top_start = top_end  = end;  //标记坡顶
//                while(top_end<ratings.length && ratings[top_end] == preR) top_end++;//找到坡顶（连续相等数）的最后一个位置
//                top_end --;
//                
////                System.out.printf("top_start=%d, top_end=%d%n",top_start, top_end);
//                end = top_end>top_start? top_start: top_end-1; //如果坡顶开始=结束，说明没有连续数，则坡的结束位置为坡顶-1，否则坡的结束位置为坡顶开始位置
////                System.out.printf("start=%d, end=%d%n", start,end);
//                while(start <= end){  //开始爬坡
//                	total += pre++;   
//                	start ++;
//                }
//                pre--;  //坡的结束位置对应的值
//                
////                System.out.println("total="+total);
//                if(top_end>top_start) total += (top_end - top_start - 1); //连续的数，如222222,则中间位置都为1， 211112，随意直接相加
////                System.out.println("total="+total);
//                if(top_end == ratings.length-1){   //如果坡顶结束位置是是数组最后一个，则直接计算
//                	total += top_end == top_start? pre +1 : 1;// 123,则为123， 1233，则为1231
//                	break;
//                }
//                else if(ratings[top_end+1] > ratings[top_end]) flag = 0; //继续爬坡
//                else flag = 1;	//下坡
//                i = top_end;    //下一个坡的开始位置为坡顶的结束位置
//                
////                System.out.printf("爬坡结束i = %d, pre = %d, flag = %d%n", i, pre, flag);
//        	}
//        	else{
////        		System.out.println("下坡。。。。。。");
//        		start = i;
//        		end = i;
//        		i++;
//            	while(i < ratings.length && ratings[i] < preR ){ //找到坡的结束位置
//	        		end++;
//	        		preR = ratings[i++];
//        	    }
//            	top_start = top_end  = end;
//            	while(top_end<ratings.length && ratings[top_end] == preR) top_end++; //找到坡底（连续相等数）的最后一个位置如21112，则top_end = 3
//            	top_end --;      	
//            	end = top_end>top_start? top_start: top_end-1;//如果坡顶开始=结束，说明没有连续数，则坡的结束位置为坡顶-1，否则坡的结束位置为坡顶开始位置
//
//            	if( pre >= end - start+1 && ratings[start-1] < ratings[start]){  //123421->123421, 4 2有断层，直接计算，坡开始位置前移
//            		total += pre+1;
//            		pre = end - start;
//            		start ++;
//            	}
//            	
//            	pre = top_start == top_end? end - start +2: end-start+1;
//            	while(start <= end){
//            		total += pre--;
//            		start ++;
//            	}
//
//            	if(top_end>top_start) total += (top_end - top_start - 1);
//
//                if(top_end == ratings.length-1){ 
//                	total += 1; //坡底的数必为1
//                	break;
//                }
//                if(ratings[top_end+1] > ratings[top_end]) flag = 0; //继续爬坡
//                else flag = 1;	//下坡
//                i = top_end;
//        	}	           
//        }
//        
//        return total ;
//    }
    //方法二：
    public int candy(int[] ratings) {

        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] count = new int[ratings.length];//每个孩子初始都有一个糖果 
        Arrays.fill(count, 1);
        int sum = 0;
        for (int i = 1; i < ratings.length; i++) {     //从左到右扫描，保证一个方向上，分数更大糖果更多
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) { //从右到左扫描，保证一个方向上，分数更大糖果更多
            sum += count[i];
            if (ratings[i] < ratings[i - 1] && count[i] >= count[i - 1]) {
                count[i - 1] = count[i] + 1;
            }
        }
        sum += count[0];
        return sum;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
		int ratings[] = {1,2,2,2,3};
		System.out.println(solution.candy(ratings));
	}
}
