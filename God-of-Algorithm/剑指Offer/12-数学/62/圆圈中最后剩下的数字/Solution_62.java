/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * <p>
 * 内容：
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 */
public class Solution_62 {

    public int lastRemainingMethod1(int n, int m) {
        if (n == 0) {
            return n;
        }
        // 递归解决，关系式：f(n, m) = (f(n-1, m) + m) % n;
        return (lastRemainingMethod1((n - 1), m) + m) % n;
    }

    public int lastRemainingMethod2(int n, int m) {
        if (n == 0) {
            return n;
        }
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

}