package candy;

import java.util.Arrays;

public class Solution {
/*	There are N children standing in a line. Each child is assigned a rating value.

	You are giving candies to these children subjected to the following requirements:

	Each child must have at least one candy.
	Children with a higher rating get more candies than their neighbors.
	What is the minimum candies you must give?*/

    //���¶�/�µ�
//    public int candy(int[] ratings) {
//        int total = 0;
//        int pre = 0;
//        int preR = 0;
//        int start = 0;    //�µĿ�ʼλ��
//        int end = 0;      //�µĽ���λ��
//        
//        int top_start = 0; //�¶����ף��Ŀ�ʼλ�ã���Ϊ�¶���׿���������������
//        int top_end = 0;   //�¶����ף��Ľ���λ�ã�Ϊ��һ���µĿ�ʼλ��
//        int flag = 0;
//        // 2222->1111, 1221->1221, 12221->12121, 12331->12321, 432213->321212, 1223->1212, 12223->12112, 433221->212121 
//        for(int i=0; i<ratings.length; ){
//        	if(flag == 0){  //����
////        		System.out.println("���¡�����������");
//        		pre = 1;    //ÿ�����¶��Ǵ�1��ʼ
//        		start = i;  //�µĿ�ʼλ��
//        		end = i;    //�µĽ���λ��
//        		preR = ratings[i++];
//            	while(i<ratings.length && preR < ratings[i]){ //�ҵ��µĽ���λ��
//	        		end++;
//	        		preR = ratings[i++];
//        	    }
//            	top_start = top_end  = end;  //����¶�
//                while(top_end<ratings.length && ratings[top_end] == preR) top_end++;//�ҵ��¶�������������������һ��λ��
//                top_end --;
//                
////                System.out.printf("top_start=%d, top_end=%d%n",top_start, top_end);
//                end = top_end>top_start? top_start: top_end-1; //����¶���ʼ=������˵��û�������������µĽ���λ��Ϊ�¶�-1�������µĽ���λ��Ϊ�¶���ʼλ��
////                System.out.printf("start=%d, end=%d%n", start,end);
//                while(start <= end){  //��ʼ����
//                	total += pre++;   
//                	start ++;
//                }
//                pre--;  //�µĽ���λ�ö�Ӧ��ֵ
//                
////                System.out.println("total="+total);
//                if(top_end>top_start) total += (top_end - top_start - 1); //������������222222,���м�λ�ö�Ϊ1�� 211112������ֱ�����
////                System.out.println("total="+total);
//                if(top_end == ratings.length-1){   //����¶�����λ�������������һ������ֱ�Ӽ���
//                	total += top_end == top_start? pre +1 : 1;// 123,��Ϊ123�� 1233����Ϊ1231
//                	break;
//                }
//                else if(ratings[top_end+1] > ratings[top_end]) flag = 0; //��������
//                else flag = 1;	//����
//                i = top_end;    //��һ���µĿ�ʼλ��Ϊ�¶��Ľ���λ��
//                
////                System.out.printf("���½���i = %d, pre = %d, flag = %d%n", i, pre, flag);
//        	}
//        	else{
////        		System.out.println("���¡�����������");
//        		start = i;
//        		end = i;
//        		i++;
//            	while(i < ratings.length && ratings[i] < preR ){ //�ҵ��µĽ���λ��
//	        		end++;
//	        		preR = ratings[i++];
//        	    }
//            	top_start = top_end  = end;
//            	while(top_end<ratings.length && ratings[top_end] == preR) top_end++; //�ҵ��µף�����������������һ��λ����21112����top_end = 3
//            	top_end --;      	
//            	end = top_end>top_start? top_start: top_end-1;//����¶���ʼ=������˵��û�������������µĽ���λ��Ϊ�¶�-1�������µĽ���λ��Ϊ�¶���ʼλ��
//
//            	if( pre >= end - start+1 && ratings[start-1] < ratings[start]){  //123421->123421, 4 2�жϲ㣬ֱ�Ӽ��㣬�¿�ʼλ��ǰ��
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
//                	total += 1; //�µ׵�����Ϊ1
//                	break;
//                }
//                if(ratings[top_end+1] > ratings[top_end]) flag = 0; //��������
//                else flag = 1;	//����
//                i = top_end;
//        	}	           
//        }
//        
//        return total ;
//    }
    //��������
    public int candy(int[] ratings) {

        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] count = new int[ratings.length];//ÿ�����ӳ�ʼ����һ���ǹ� 
        Arrays.fill(count, 1);
        int sum = 0;
        for (int i = 1; i < ratings.length; i++) {     //������ɨ�裬��֤һ�������ϣ����������ǹ�����
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) { //���ҵ���ɨ�裬��֤һ�������ϣ����������ǹ�����
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
