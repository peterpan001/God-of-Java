package leetcode_0000_0299.leetcode_0200_0299.leetcode0287;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lipan
 * <p>
 * 题目：
 * 287. 寻找重复数
 * <p>
 * 内容：
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class Solution_0287 {

    /**
     * 哈希法
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return 0;
    }
}
