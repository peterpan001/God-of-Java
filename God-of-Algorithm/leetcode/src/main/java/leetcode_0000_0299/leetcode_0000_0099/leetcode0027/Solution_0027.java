package leetcode_0000_0299.leetcode_0000_0099.leetcode0027;

/**
 * @author lipan
 * <p>
 * 题目：
 * 27. 移除元素
 * <p>
 * 内容：
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。元素的顺序可以改变。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution_0027 {

    /**
     * 左/右指针解决问题
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElementMethod1(int[] nums, int val) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 定义左/右指针
        int left = 0, right = nums.length - 1;
        // 左指针小于右指针
        while (left < right) {
            // 如果左指针小于右指针且左指针元素不等于val，左指针右移
            while (left < right && nums[left] != val) {
                left++;
            }
            // 如果左指针小于右指针且右指针元素等于val，右指针左移
            while (left < right && nums[right] == val) {
                right--;
            }
            // 当左指针小于右指针时，交换元素位置
            if (left < right) {
                nums[left] = nums[right];
                nums[right] = val;
            }
        }
        // 如果左指针元素等于 val，返回左指针下标即可，否则+1，应对所有元素都不等于 val
        return nums[left] == val ? left : left + 1;
    }

    /**
     * 快慢指针解决问题
     */
    public int removeElementMethod2(int[] nums, int val) {
        // 边界
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            // 如果r元素不等于val，则将元素放入开头位置，依次摆放，l++
            if (nums[r] != val) {
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }
}
