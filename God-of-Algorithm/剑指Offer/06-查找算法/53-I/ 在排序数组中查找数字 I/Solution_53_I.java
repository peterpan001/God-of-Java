/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * <p>
 * 内容：
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution_53_I {

    /**
     * 常见查找场景：
     * 1. 寻找第一个大于等于 target 的数；
     * 2. 寻找第一个等于 target 的数；
     * 3. 寻找最后一个大于等于 target 的数；
     * 4. 寻找最有一个等于 target 的数；
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = search2(nums, target);
        int end = search4(nums, target);
        if (start < 0 || end < 0) {
            return 0;
        }
        return end - start + 1;
    }

    /**
     * 寻找第一个大于等于 target 的数；
     */
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] >= target) {
            return left;
        }
        return -1;
    }

    /**
     * 寻找第一个等于 target 的数；
     */
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 向下取整
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 寻找最后一个大于等于 target 的数；
     */
    public int search3(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return -1;
    }

    /**
     * 寻找最有一个等于 target 的数；
     */
    public int search4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 向上取整
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] != target) {
            return -1;
        }
        return left;
    }


}