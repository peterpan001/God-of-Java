package leetcode_0000_0299.leetcode_0000_0099.leetcode0049;

import java.util.*;

/**
 * @author lipan
 * <p>
 * 题目：
 * 49. 字母异位词分组
 * <p>
 * 内容：
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class Solution_0049 {

    /**
     * 借助字符数组排序 + HashMap 实现
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 边界条件
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        // 借助 HashMap 来解决
        Map<String, List<String>> map = new HashMap<>();
        // 遍历字符串数组
        for (String str : strs) {
            // 将字符串转化为字符数组
            char[] chars = str.toCharArray();
            // 将字符数组排序
            Arrays.sort(chars);
            // 将其作为 map 的 key
            String key = new String(chars);
            // 将 key 相同的都放到 val 中
            List<String> list;
            if (!map.containsKey(key)) {
                list = new ArrayList<>();
            } else {
                list = map.get(key);
            }
            list.add(str);
            map.put(key, list);
        }
        // 返回
        return new ArrayList<>(map.values());
    }
}
