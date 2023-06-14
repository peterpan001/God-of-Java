/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 10- I. 斐波那契数列
 * <p>
 * 内容：
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
class Solution_10_I {

    /**
     * 斐波那契数列最原始解法：因为递归可能造成时间超时，需进行优化
     * 递推公式：fib(n) = fib(n - 1) + fib(n - 2)
     */
    public int fib1(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    // 上述做法的优化，从底层直接向上找到第 n 个数
    // 递推公式：fib(n) = fib(n - 1) + fib(n - 2)
    public int fib2(int n) {
        if(n <= 1){
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for(int i = 2; i <= n; i++){
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return b;
    }

}