/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 57. 和为s的两个数字
 * <p>
 * 内容：
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
class Solution_57 {

    /**
     * 两数相加和位 target，利用左右指针进行解答
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[0];
        }
        int l = 0;
        int r = nums.length - 1;
        // 此处判断条件新增 nums[l] <= target / 2 进行优化，会减少循环次数
        while (l < r && nums[l] <= target / 2) {
            if (target > nums[l] + nums[r]) {
                l++;
            } else if (target < nums[l] + nums[r]) {
                r--;
            } else {
                return new int[]{nums[l], nums[r]};
            }
        }
        return new int[0];
    }
}