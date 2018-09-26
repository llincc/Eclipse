package container_with_most_water;
/*��Ŀ����

Given n non-negative integers a1 , a2 , ..., an , where each represents a point at coordinate (i, ai ). n vertical lines are drawn such that the two endpoints of line i is at (i, ai ) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.*/
public class Solution {
    public int maxArea1(int[] height) {
    	int maxvalue = 0;
        for(int i=0; i<height.length-2; i++){
        	for(int j=i+1; j<height.length; j++){
        		maxvalue = Math.max((j-i)*Math.min(height[i], height[j]), maxvalue);
        	}
        }
        return maxvalue;
    }
    /*���ӣ�https://www.nowcoder.com/questionTerminal/c97c1400a425438fb130f54fdcef0c57
    	��Դ��ţ����

    	������ؼ��������㣬һ���������м��ң�����ÿ�η�����̵İ档
    	��ô����ԭ�����ڣ��������յ㿪ʼ�ң���������ʱÿ�ƶ�һ������һ���㣬��Ȼ��ȱ�С��
    	���һ�����������ֻ�и߶��������п���������ȥ������----�̰壬�������߶Ƚ�С�ĵ㡣*/
    public int maxArea(int[] height) {
    	int maxvalue = 0;
        int left = 0;
        int right = height.length - 1;
        while(left<right){
        	if(height[left] <= height[right]){
        		maxvalue = Math.max((right-left)*height[left++], maxvalue);
        	}
        	else{
        		maxvalue = Math.max((right-left)*height[right--], maxvalue);
        	}
        }
        return maxvalue;
    }
}
