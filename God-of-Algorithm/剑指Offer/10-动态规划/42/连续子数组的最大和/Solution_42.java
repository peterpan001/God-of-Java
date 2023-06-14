/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 42. 连续子数组的最大和
 * <p>
 * 内容：
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 */
public class Solution_42 {

    /**
     * O(n)的空间复杂度，O(n)的时间复杂度解决方法
     */
    public int maxSubArrayMethod1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        int max = res[0];
        for (int i = 1; i < nums.length; i++) {
            if (res[i - 1] + nums[i] < nums[i]) {
                res[i] = nums[i];
            } else {
                res[i] = nums[i] + res[i - 1];
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }

    /**
     * 优化为O(1)的空间复杂度
     */
    public int maxSubArrayMethod2(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 存储最大值
        int max = nums[0];
        // 存储临时变量
        int tmp = nums[0];
        // 循环遍历寻找最长连续子数组的和
        for (int i = 1; i < nums.length; i++) {
            if (tmp + nums[i] < nums[i]) {
                tmp = nums[i];
            } else {
                tmp = tmp + nums[i];
            }
            max = Math.max(max, tmp);
        }
        return max;
    }
}