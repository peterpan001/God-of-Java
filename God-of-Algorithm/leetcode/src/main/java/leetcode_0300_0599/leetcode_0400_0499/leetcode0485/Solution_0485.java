package leetcode_0300_0599.leetcode_0400_0499.leetcode0485;

/**
 * @author lipan
 * <p>
 * 题目：
 * 485. 最大连续 1 的个数
 * <p>
 * 内容：
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 */
public class Solution_0485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 记录最大结果
        int result = 0;
        // 记录当前连续1的个数
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                result = Math.max(result, cnt);
                cnt = 0;
            }
        }
        // 结尾连续为1时，需要此步骤来验证
        return Math.max(result, cnt);
    }
}
