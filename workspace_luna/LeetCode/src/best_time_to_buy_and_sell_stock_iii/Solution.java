package best_time_to_buy_and_sell_stock_iii;

/*��Ŀ����

Say you have an array for which the i th element is the price of a given stock on day i.

If you were only permitted to complete at most 2 transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.*/
public class Solution {
	
	 //����0~0,1,2,...,len-1���ε�ȡ���������������С
	 //����0,1,2,....,len-1~len-1���ε�ȡ���������������С
	 //����0~i, i+1~len-1����������ֵ
	 public int maxProfit1(int[] prices) {
		 if(prices.length<=1) return 0;
		 
		 int profit = 0;
		 
		 int l2r_max_min[][] = new int[prices.length][2];
		 int r2l_max_min[][] = new int[prices.length][2];
		 
		 int min;
		 int max;
		 
		 l2r_max_min[0][0] = l2r_max_min[0][1] = min = max = prices[0];
		 
		 for(int i=1; i<prices.length; i++){	 
			 if(prices[i] - min > l2r_max_min[i-1][0]-l2r_max_min[i-1][1]){
				 l2r_max_min[i][0] = prices[i];
				 l2r_max_min[i][1] = min;
			 }
			 else{
				 l2r_max_min[i][0] = l2r_max_min[i-1][0];
				 l2r_max_min[i][1] = l2r_max_min[i-1][1];
			 }
			 min = Math.min(min, prices[i]);		 
//			 System.out.printf("%d %d %n",  l2r_max_min[i][0] , l2r_max_min[i][1] );
		 }
		 
		 r2l_max_min[prices.length-1][0] = r2l_max_min[prices.length-1][1] = min = max = prices[prices.length-1];
		 for(int i=prices.length-2; i>=0; i--){
			 
			 if(max - prices[i]> r2l_max_min[i][0] - r2l_max_min[i][1]){
				 r2l_max_min[i][1] = prices[i];
				 r2l_max_min[i][0] = max;
			 }
			 else{
				 r2l_max_min[i][0] = r2l_max_min[i+1][0];
				 r2l_max_min[i][1] = r2l_max_min[i+1][1];	
			 }
			 max = Math.max(prices[i], max);
//			 System.out.printf("%d %d %n",  r2l_max_min[i][0] , r2l_max_min[i][1] );
			 
		 }
		 profit = l2r_max_min[prices.length-1][0] -l2r_max_min[prices.length-1][1];
		 
		 for(int i=1; i<prices.length; i++){
			 profit = Math.max(profit, l2r_max_min[i-1][0]-l2r_max_min[i-1][1] + r2l_max_min[i][0] - r2l_max_min[i][1]);
		 }
		 return profit;	 
	 }
	 
	 //��
	 public int maxProfit2(int[] prices) {
		 if(prices.length<=1) return 0;
		 int profit = 0;
		 int l2rprofit[] = new int[prices.length];
		 int r2lprofit[] = new int[prices.length];
		 
		 int min = prices[0];	 
		 l2rprofit[0] = 0;
		 for(int i=1; i<prices.length; i++){	 
			 l2rprofit[i] = Math.max(prices[i]-min, l2rprofit[i-1]);
			 min = Math.min(min, prices[i]);	
		 }
		 int max = prices[prices.length-1];
		 r2lprofit[prices.length-1] = 0;
		 for(int i=prices.length-2; i>=0; i--){
			 r2lprofit[i] = Math.max(max - prices[i], r2lprofit[i+1]);
			 max = Math.max(prices[i], max);
		 }
		 profit = l2rprofit[prices.length-1];
		 for(int i=1; i<prices.length-1; i++){
			 profit = Math.max(profit, l2rprofit[i-1] + r2lprofit[i]);
		 }
		 return profit;	 
	 }
	//�ռ�
	 public int maxProfit(int[] prices) {
		 int buy1 = Integer.MIN_VALUE;
		 int buy2 = Integer.MIN_VALUE;
		 int sell1 = 0;
		 int sell2 = 0;
		 for(int price: prices){
			 buy1  = Math.max(buy1, - price);       //��¼֮ǰ����������˵Ĺɼ�, ��һ�����  ��Ϊ�ǻ�Ǯ������׬�� - prices[i]Ԫ  , Ҫѡ����Ǯ���ٵ�������
			 //��Ϊbuy1 = -price, ֮��sell��+price����ô�ͱ��pricei - pricej, ��������best_time_to_buy_and_sell_stock��һ��������ֻ�ǰ�-�ĳ���+
			 sell1 = Math.max(sell1, buy1 + price); //��¼֮ǰ������ֻ����1���������������, //��һ������  ׬��Ǯ
			 buy2  = Math.max(buy2, sell1 - price); //��¼֮ǰ���Ƚ���1�ν��׻����������//�����Ǵν��׺�����˹ɼ�ʱʣ��ľ�����
			 sell2 = Math.max(sell2, buy2 + price); //��¼֮ǰ�����2���������׵��������
		 }
		 //����1,2,1,3������
		 return sell2;	 
	 }
    
    public static void main(String[] args) {
		int prices[] = {1,2,4,2,1,5,1,6,2,1};
		System.out.println(new Solution().maxProfit(prices));
	}
}
