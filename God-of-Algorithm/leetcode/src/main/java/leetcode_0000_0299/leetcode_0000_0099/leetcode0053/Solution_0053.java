package leetcode_0000_0299.leetcode_0000_0099.leetcode0053;

/**
 * @author lipan
 * <p>
 * 题目：
 * 53. 最大子数组和
 * <p>
 * 内容：
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */
public class Solution_0053 {

    /**
     * 一道简单的动态规划题
     */
    public int maxSubArrayMethod1(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArrayMethod2(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int max = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }
}
