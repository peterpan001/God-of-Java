package leetcode_0000_0299.leetcode_0200_0299.leetcode0217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lipan
 * <p>
 * 题目：
 * 217. 存在重复元素
 * <p>
 * 内容：
 * 给你一个整数数组 nums。如果任一值在数组中出现至少两次，返回 true；如果数组中每个元素互不相同，返回 false 。
 */
public class Solution_0217 {

    /**
     * 排序法
     */
    public boolean containsDuplicateMethod1(int[] nums) {
        // 边界条件
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 借助 Set 集合
     */
    public boolean containsDuplicateMethod2(int[] nums) {
        // 边界条件
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
