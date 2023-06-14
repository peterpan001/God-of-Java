package leetcode_0000_0299.leetcode_0200_0299.leetcode0268;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lipan
 * <p>
 * 题目：
 * 268. 丢失的数字
 * <p>
 * 内容：
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class Solution_0268 {

    /**
     * 排序
     */
    public int missingNumberMethod1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * Set 集合
     */
    public int missingNumberMethod2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 数学法
     */
    public int missingNumberMethod3(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int total = len * (len + 1) / 2;
        return total - sum;
    }
}
