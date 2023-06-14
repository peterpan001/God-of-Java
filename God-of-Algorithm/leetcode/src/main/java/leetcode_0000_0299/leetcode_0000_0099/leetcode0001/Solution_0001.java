package leetcode_0000_0299.leetcode_0000_0099.leetcode0001;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * <p>
 * 题目：
 * 1. 两数之和
 * <p>
 * 内容：
 * 给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 */
public class Solution_0001 {

    /**
     * 借助 hashMap 实现
     */
    public int[] twoSum(int[] nums, int target) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        // 将元素放入hashmap，key为num，value为下标索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            // 如果包含tmp则返回它们对应的下标即可
            if (map.containsKey(tmp)) {
                return new int[]{i, map.get(tmp)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
