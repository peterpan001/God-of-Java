package leetcode_0300_0599.leetcode_0500_0599.leetcode0509;

/**
 * @author lipan
 * <p>
 * 题目：
 * 509. 斐波那契数
 * <p>
 * 内容：
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，
 * 后面的每一项数字都是前面两项数字的和。也就是：
 * * F(0) = 0，F(1) = 1
 * * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 */
public class Solution_0509 {

    /**
     * 使用递归解决
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 使用动态规划解决
     */
    public int fibMethod2(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    /**
     * 使用动态规划解决
     */
    public int fibMethod3(int n) {
        if (n < 2) {
            return n;
        }
        int pre = 0, cur = 0, res = 1;
        for (int i = 2; i <= n; i++) {
            pre = cur;
            cur = res;
            res = pre + cur;
        }
        return res;
    }
}
