package leetcode_0000_0299.leetcode_0200_0299.leetcode0264;

/**
 * @author lipan
 * <p>
 * 题目：
 * 264. 丑数 II
 * <p>
 * 内容：
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class Solution_0264 {

    /**
     * 动态规划
     */
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }
        int[] uglyNums = new int[n + 1];
        uglyNums[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = uglyNums[p2] * 2;
            int num3 = uglyNums[p3] * 3;
            int num5 = uglyNums[p5] * 5;
            uglyNums[i] = Math.min(num2, Math.min(num3, num5));
            if (uglyNums[i] == num2) {
                p2++;
            }
            if (uglyNums[i] == num3) {
                p3++;
            }
            if (uglyNums[i] == num5) {
                p5++;
            }
        }
        return uglyNums[n];
    }
}
