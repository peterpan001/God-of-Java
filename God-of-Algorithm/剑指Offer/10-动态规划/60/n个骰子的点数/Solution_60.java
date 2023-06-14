/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 60. n个骰子的点数
 * <p>
 * 内容：
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */
public class Solution_60 {

    /**
     * dp[i][j] 为当骰子个数为i时，点数为j时，一定有dp[i][j]种组合，概率为：dp[i][j]/6^n；
     * <p>
     * dp[i][j] =
     * dp[i-1][j-1] + dp[i-1][j-2] + dp[i-1][j-3] + dp[i-1][j-4] + dp[i-1][j-5] + dp[i-1][j-6]
     */
    public double[] dicesProbability(int n) {
        if (n < 1) {
            return new double[0];
        }
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j < k) {
                        break;
                    }
                    dp[i][j] = dp[i][j] + dp[i - 1][j - k];
                }
            }
        }
        double[] res = new double[5 * n + 1];
        int idx = 0;
        double sum = Math.pow(6, n);
        for (int i = n; i <= 6 * n; i++) {
            res[idx++] = dp[n][i] / sum;
        }
        return res;
    }
}