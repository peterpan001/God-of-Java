package leetcode_0000_0299.leetcode_0100_0199.leetcode0169;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * <p>
 * 题目：
 * 169. 多数元素
 * <p>
 * 内容：
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution_0169 {

    /**
     * 借助 Map 实现，空间复杂度较高
     */
    public int majorityElementMethod1(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 遍历 nums
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 动态计数法
     */
    public int majorityElementMethod2(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int tmp = nums[0];
        int cnt = 1;
        // 遍历数组
        for (int i = 1; i < nums.length; i++) {
            // 如果元素与 tmp 相等，计数++
            if (nums[i] == tmp) {
                cnt++;
            } else {
                // 如果 cnt 为 0，将 tmp 赋值给 tmp，cnt 归为 1，否则 cnt--；
                if (cnt == 0) {
                    tmp = nums[i];
                    cnt = 1;
                } else {
                    cnt--;
                }
            }
        }
        return tmp;
    }
}
