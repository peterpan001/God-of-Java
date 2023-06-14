package leetcode_0600_0999.leetcode_0700_0799.leetcode0704;

/**
 * @author lipan
 * <p>
 * 题目：
 * 704. 二分查找
 * <p>
 * 内容：
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 */
public class Solution_0704 {

    /**
     * 二分查找
     */
    public int search(int[] nums, int target) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 左右指针
        int left = 0;
        int right = nums.length - 1;
        // 退出循环条件
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
