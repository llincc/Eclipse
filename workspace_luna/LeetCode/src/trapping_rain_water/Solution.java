package trapping_rain_water;

import java.util.Stack;

/*��Ŀ����

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given[0,1,0,2,1,0,1,3,2,1,2,1], return6.



The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!*/
public class Solution {
    public int trap1(int[] A) {
        if(A.length<=2) return 0;
        int lefttop = A[0], righttop = A[A.length-1];
        int i=1, j=A.length-2;
        int sums = 0;
        //��ȫ����������lefttop<= righttopʱ��A[i]С��lefttopһ���ܻ�ˮ(���Բ������ұ����ˮ)
        //            ��righttop>lefttopʱ��  A[j]С��righttop��Ҳһ���ܻ�ˮ(���Բ�������߱����ˮ)
        while(i<=j){
        	if(lefttop>righttop){
        		sums += Math.max(0, righttop-A[j]);   //if(rightop>A[j]) sum+= righttop-A[j] else righttop = A[j]
        		righttop = Math.max(righttop, A[j]);
        		--j;
        	}
        	else{
        		sums += Math.max(0, lefttop-A[i]);
        		lefttop = Math.max(lefttop, A[i]);
        		++i;
        	}
        }
        return sums;
    }
    public int trap2(int[] A) {
        if(A.length<=2) return 0;
        int lefttop = A[0], righttop = A[A.length-1];
        int i=1, j=A.length-2;
        int sums = 0;
        //��ȫ����������lefttop<= righttopʱ��A[i]С��lefttopһ��������ʧ���ܻ�ˮ
        //           ��righttop>lefttopʱ��      A[j]С��righttop��Ҳһ���ܻ�ˮ
        while(i<=j){
        	if(lefttop>righttop){
        	    if(righttop>=A[j]) sums+= righttop-A[j];
        	    else righttop = A[j];
        		--j;
        	}
        	else{
        		if(lefttop>=A[i]) sums+= lefttop-A[i];
        		else lefttop = A[i];
        		++i;
        	}
        }
        return sums;
    }

    int trap(int heights[], int n) {
    	int maxhigh=0;
    	int left=0,right=0;
    	for(int i=0;i<n;i++)//�ҵ����ֵ���±�
    	{
    		if(heights[i]>heights[maxhigh])
    			maxhigh=i;
    	}
    	int sum=0;
    	for(int i=0;i<maxhigh;i++)//������ߵ�����
    	{
    		if(heights[i]<left)
    			sum+=(left-heights[i]);
    		else
    			left=heights[i];
    	}
    	
    	for(int j=n-1;j>maxhigh;j--)//�����ұߵ�����
    	{
    		if(heights[j]<right)
    			sum+=(right-heights[j]);
    		else
    			right=heights[j];
    	}
    	return sum;
    }
}
