package leetcode_0000_0299.leetcode_0100_0199.leetcode0162;

/**
 * @author lipan
 * <p>
 * 题目：
 * 162. 寻找峰值
 * <p>
 * 内容：
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */
public class Solution_0162 {

    /**
     * 暴力方法
     */
    public int findPeakElementMethod1(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int peekNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[peekNum] < nums[i]) {
                peekNum = i;
            }
        }
        return peekNum;
    }

    /**
     * 二分法，题目中是寻找其中的一个峰值即可，即只需要看 mid 和 mid+1 的关系，即可判断出峰值所在区域
     * left=right：即为峰值位置
     */
    public int findPeakElementMethod2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
