/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 46. 把数字翻译成字符串
 * <p>
 * 内容：
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，
 * 25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class Solution_46 {

    /**
     * 根据题目可知此题，dp[i]由，dp[i-1]和dp[i-2]决定；
     * 当 10 * (dp[i-2] - '0') + (dp[i-2] - '0') 大于等于10且小于等于25时：
     * dp[i] = dp[i-1] + dp[i-2]
     * 否则：
     * dp[i] = dp[i-1]
     */
    public int translateNumMethod1(int num) {
        if (num <= 9) {
            return 1;
        }
        char[] arr = String.valueOf(num).toCharArray();
        int len = arr.length;
        int[] dp = new int[len + 1];
        // 赋予初始值
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            int tmp = 10 * (arr[i - 2] - '0') + (arr[i - 1] - '0');
            if (tmp >= 10 && tmp <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }

    /**
     * 上面的优化，由O(n)的空间优化为O(1)
     */
    public int translateNumMethod2(int num) {
        if (num <= 9) {
            return 1;
        }
        char[] arr = String.valueOf(num).toCharArray();
        int len = arr.length;
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= len; i++) {
            int tmp = 10 * (arr[i - 2] - '0') + (arr[i - 1] - '0');
            if (tmp >= 10 && tmp <= 25) {
                c = a + b;
            } else {
                c = b;
            }
            a = b;
            b = c;
        }
        return b;
    }
}