package leetcode_0300_0599.leetcode_0300_0399.leetcode0342;

/**
 * @author lipan
 * <p>
 * 题目：
 * 342. 4的幂
 * <p>
 * 内容：
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 */
public class Solution_0342 {


    /**
     * 二分法
     */
    public boolean isPowerOfFourMethod1(int n) {
        // 边界条件
        if (n < 1) {
            return false;
        }
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long result = (long) Math.pow(4, mid);
            if (result == n) {
                return true;
            } else if (result > n) {
                right = mid - 1;
            } else if (result < n) {
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * 位运算
     */
    public boolean isPowerOfFourMethod2(int n) {
        if (n < 1) {
            return false;
        }
        return ((n & (n - 1)) == 0) && (n % 3 == 1);
    }
}
