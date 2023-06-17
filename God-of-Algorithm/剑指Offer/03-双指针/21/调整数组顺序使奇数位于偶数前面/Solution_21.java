/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * <p>
 * 内容：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 */
public class Solution_21 {

    /**
     * 借助双指针进行解答
     * 此题还可以开辟O(n)的空间进行解答
     */
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            // 注意边界条件
            while (nums[l] % 2 == 1 && l < r) {
                l++;
            }
            // 注意边界条件
            while (nums[r] % 2 == 0 && l < r) {
                r--;
            }
            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r--;
            }
        }
        return nums;
    }
}