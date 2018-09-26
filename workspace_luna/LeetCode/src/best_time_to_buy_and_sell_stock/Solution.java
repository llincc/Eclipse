package best_time_to_buy_and_sell_stock;

/*题目描述

Say you have an array for which the i th element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.*/
public class Solution {
//	int profit;
//    public int maxProfit(int[] prices) {
//    	if(prices.length <= 1) return 0;
//    	
//    	profit = 0;
//        bestProfit(prices, 0, prices.length-1);
//        return profit;
//    }
//    方法1
//    public int[] bestProfit(int []prices, int left, int right){ //二分查找，分别返回左右边的最大最小值
//    	int max_min[] = new int[2];
//    	if(left == right){
//    		max_min[0] = max_min[1] = prices[left];
//    		return max_min;
//    	}
//    	int mid = (left + right) /2;
//    	int leftMaxMin[] = bestProfit(prices, left, mid);
//    	int rightMaxMin[] = bestProfit(prices, mid+1, right);
//    	profit = Math.max(rightMaxMin[0]-leftMaxMin[1], profit);
//    	max_min[0] = Math.max(leftMaxMin[0], rightMaxMin[0]);
//    	max_min[1] = Math.min(leftMaxMin[1], rightMaxMin[1]);
//    	return max_min;
//    }
//    方法二
	 public int maxProfit(int[] prices) {
		if(prices.length <= 1) return 0;
		
		int max = 0;
		int min = prices[0];
		for(int i=0; i<prices.length; i++){
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i]-min);
		}
		return max;
	 }
    
    public static void main(String[] args) {
		int prices[] = {1,2,3,4};
		System.out.println(new Solution().maxProfit(prices));
	}
}
