package leetcode_0000_0299.leetcode_0200_0299.leetcode0283;

/**
 * @author lipan
 * <p>
 * 题目：
 * 283. 移动零
 * <p>
 * 内容：
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Solution_0283 {

    /**
     * 快慢指针
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }
        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
