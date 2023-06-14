/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 16. 数值的整数次方
 * <p>
 * 内容：
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */
class Solution_16 {

    /**
     * 此题注意事项：n 为负数时转为 -n，可能会超出int范围，所以需要转为 long 类型
     */
    public double myPow(double x, int n) {
        double res = 1.0;
        long n1 = n;
        if(n1 < 0){
            n1 = -n1;
            x = 1 / x;
        }
        while(n1 > 0){
            // 此解法巧妙之处
            if(n1 % 2 == 1){
                res *= x;
            }
            x = x * x;
            n1 = n1 / 2;
        }
        return res;
    }
}