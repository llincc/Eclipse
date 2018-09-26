package best_time_to_buy_and_sell_stock_ii;

/*��Ŀ����

Say you have an array for which the i th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).*/
public class Solution {
	
	 //����һ���ж������Ƿ��������Ϊ�����������Ժ�������Ϊһ��������������������ͳ�����е���������
	 public int maxProfit(int[] prices) {
		 if(prices.length<=1) return 0;
		 int profit = 0;
		 for(int i=1; i<prices.length; i++) profit += Math.max(prices[i]-prices[i-1], 0);
		 return profit;
//			 if(prices[i]>prices[i-1]) profit += prices[i] - prices[i-1];
	 }
	
	
//     //��������ÿ�����������
//	 public int maxProfit(int[] prices) {
//		if(prices.length <= 1) return 0;
//		
//		int profit = 0;
//		int max = prices[0];
//		int min = prices[0];
//		for(int i=1; i<prices.length; i++){
//			if(max>=prices[i]){
//				profit += max - min;
//				while(i<prices.length && prices[i]<=prices[i-1]) i++; //�ҵ���һ������
//				max = min = prices[i-1];		
//	            i--;
//			}
//			else{
//				max = prices[i];
//			}
//		}
//		profit += max - min;
//		
//		return profit;
//	 }
    
    public static void main(String[] args) {
		int prices[] = {1,2,3,4};
		System.out.println(new Solution().maxProfit(prices));
	}
}
