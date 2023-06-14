package leetcode_0000_0299.leetcode_0000_0099.leetcode0035;

/**
 * @author lipan
 * <p>
 * 题目：
 * 35. 搜索插入位置
 * <p>
 * 内容：
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，
 * 返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class Solution_0035 {

    /**
     * 二分查找法
     */
    public int searchInsert(int[] nums, int target) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 声明左右指针
        int left = 0, right = nums.length - 1;
        // 边界条件，如果left == right 时还没找到元素，说明此时left位置即为元素插入位置
        // 如果找到相关元素，那么此元素位置即为插入元素位置
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
        return left;
    }

}
