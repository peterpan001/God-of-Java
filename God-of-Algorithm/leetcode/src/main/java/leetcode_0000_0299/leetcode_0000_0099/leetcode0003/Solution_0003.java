package leetcode_0000_0299.leetcode_0000_0099.leetcode0003;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * <p>
 * 题目：
 * 3. 无重复字符的最长子串
 * <p>
 * 内容：
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution_0003 {

    public int lengthOfLongestSubstring(String s) {
        // 边界条件
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 将字符串转为字符数组
        char[] arrs = s.toCharArray();
        // 借助 Map
        Map<Character, Integer> map = new HashMap<>();
        // 定义不重复字符左边界
        int left = 0;
        // 存储最大不重复字符长度
        int max = 0;
        for (int i = 0; i < arrs.length; i++) {
            // 判断之前的字符是否已存在于map中
            if (map.containsKey(arrs[i])) {
                // 获取最大不重复最边界
                left = Math.max(left, map.get(arrs[i]) + 1);
            }
            // 将当前元素放入map中
            map.put(arrs[i], i);
            // 求取最大长度
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
