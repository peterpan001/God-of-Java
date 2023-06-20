/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * <p>
 * 内容：
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class Solution_53_II {

    /**
     *
     */
    public int missingNumber(int[] nums) {
        // 边界条件
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        // 声明左右指针
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 取 mid 值
            int mid = left + (right - left) / 2;
            // 如果 nums[mid] == mid，表示缺失的数字在右侧
            if (nums[mid] == mid) {
                left = mid + 1;
            } else { //  缺失的数字在左侧
                right = mid;
            }
        }
        // 如果 nums[left] == left 代表数组元素不缺元素
        return nums[left] == left ? left + 1 : left;
    }
}