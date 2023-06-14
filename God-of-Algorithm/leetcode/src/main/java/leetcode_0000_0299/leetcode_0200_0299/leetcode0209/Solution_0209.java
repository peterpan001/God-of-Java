package leetcode_0000_0299.leetcode_0200_0299.leetcode0209;

/**
 * @author lipan
 * <p>
 * 题目：
 * 209. 长度最小的子数组
 * <p>
 * 内容：
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0
 */
public class Solution_0209 {

    /**
     * 暴力法
     */
    public int minSubArrayLenMethod1(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = 1;
        while (size <= nums.length) {
            for (int i = 0; i <= nums.length - size; i++) {
                int sum = 0;
                for (int j = i; j < i + size; j++) {
                    sum += nums[j];
                }
                if (sum >= target) {
                    return size;
                }
            }
            size++;
        }
        return 0;
    }

    /**
     * 双指针法
     */
    public int minSubArrayLenMethod2(int target, int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        int result = nums.length + 1;
        int sum = 0;
        while (fast < nums.length) {
            sum += nums[fast];
            fast++;
            while (sum >= target) {
                result = Math.min(result, fast - slow);
                sum -= nums[slow];
                slow++;
            }
        }
        return result == nums.length + 1 ? 0 : result;
    }
}
