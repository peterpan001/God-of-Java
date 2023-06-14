/**
 * @author lipan
 * <p>
 * 题目：
 * 找出数组中重复的数字
 * <p>
 * 内容：
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
 */
public class Solution_03 {

    /**
     * 借助 O(n) 的辅助空间找到重复的元素
     */
    public int findRepeatNumberMethod1(int[] nums) {
        // 边界条件
        if (nums == null || nums.length <= 1) {
            return -1;
        }
        // 声明 O(n) 辅助空间来判断 0～n-1 是否有重复
        boolean[] flag = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 遍历数组并在每一个对应的位置打表，遇到true的位置就代表有重复的
            if (!flag[nums[i]]) {
                flag[nums[i]] = true;
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 原地交换，借助一个辅助变量完成查找重复元素
     */
    public int findRepeatNumberMethod2(int[] nums) {
        // 边界条件
        if (nums == null || nums.length <= 1) {
            return -1;
        }
        int idx = 0;
        // 原地交换：
        // 将 nums[idx]元素交换到对应的下标位置，如果遇到 nums[idx] == nums[nums[idx]] 代表元素重复了；
        // 否则将 num[idx] 元素放到其值所对应的下标的位置，使：idx == nums[idx]
        while (idx < nums.length) {
            if (nums[idx] == idx) {
                idx++;
                continue;
            }
            if (nums[nums[idx]] == nums[idx]) {
                return nums[idx];
            }
            // 交换，注意下面交换规则
//            int tmp1 = nums[idx];
//            int tmp2 = nums[nums[idx]];
//            nums[nums[idx]] = tmp1;
//            nums[idx] = tmp2;
            int tmp = nums[idx];
            nums[idx] = nums[tmp];
            nums[tmp] = tmp;

        }
        return -1;
    }
}