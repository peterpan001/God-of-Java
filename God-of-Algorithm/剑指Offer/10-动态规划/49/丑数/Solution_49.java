/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 49. 丑数
 * <p>
 * 内容：
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 */
public class Solution_49 {

    /**
     * 题目找丑数：丑数只有质因子：2，3，5的数组成，dp[1]为1，则后续的丑数就是dp[i]乘以2，3，或者5构成，且
     * dp[i+1]一定是其中最小的一个
     */
    public int nthUglyNumber(int n) {
        int a = 1, b = 1, c = 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 求出dp[i]最小的一个
            int minTmp = Math.min(dp[a] * 2, dp[b] * 3);
            dp[i] = Math.min(minTmp, dp[c] * 5);
            if (dp[i] == dp[a] * 2) {
                a++;
            }
            if (dp[i] == dp[b] * 3) {
                b++;
            }
            if (dp[i] == dp[c] * 5) {
                c++;
            }
        }
        return dp[n];
    }
}