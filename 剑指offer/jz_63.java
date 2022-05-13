package 剑指offer;

/**
 * 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class jz_63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int preMin = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - preMin);
            preMin = Math.min(preMin, prices[i]);
        }
        return maxProfit;
    }
}
