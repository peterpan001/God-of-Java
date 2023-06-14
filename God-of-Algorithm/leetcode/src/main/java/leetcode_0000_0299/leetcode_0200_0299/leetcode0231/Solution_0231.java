package leetcode_0000_0299.leetcode_0200_0299.leetcode0231;

/**
 * @author lipan
 * <p>
 * 题目：
 * 231. 2 的幂
 * <p>
 * 内容：
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 */
public class Solution_0231 {


    /**
     * 二分法
     */
    public boolean isPowerOfTwoMethod1(int n) {
        if (n < 1) {
            return false;
        }
        int start = 0;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 此处担心溢出
            long result = (long) Math.pow(2, mid);
            if (result > n) {
                end = mid - 1;
            } else if (result < n) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }


    /**
     * 位运算法
     */
    public boolean isPowerOfTwoMethod2(int n) {
        if (n < 1) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
