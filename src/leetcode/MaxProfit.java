package leetcode;

/**
 * @ClassName MaxProfit
 * @Description 121. Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * @Author NebulaPort
 * @Date 2019/8/30 20:13
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }
    public static int maxProfit(int[] prices) {
       int n=prices.length;
       if (n<1) {
           return 0;
       }
       //到第i天的最大收益
       int[] maxProfit=new int[n];
       //第i天前的最低价格
       int[] minPrice=new int[n];
       minPrice[0]=prices[0];
       maxProfit[0]=0;
        for (int i = 1; i < n; i++) {
            minPrice[i]=Math.min(minPrice[i-1],prices[i]);
            maxProfit[i]=Math.max(maxProfit[i-1],prices[i]-minPrice[i-1]);
        }
        return maxProfit[n-1];
    }

    public static int maxProfit2(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
