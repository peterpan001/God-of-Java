/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 63. 股票的最大利润
 * <p>
 * 内容：
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class Solution_63 {

    /**
     * 股票的最大利润寻找出：股票中的最小值及最小值后面的最大值的差，即为利润的最大值
     */
    public int maxProfit(int[] prices) {
        // 边界判断
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 记录当前股票的最小值
        int min = Integer.MAX_VALUE;
        // 记录最大利润
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }
}