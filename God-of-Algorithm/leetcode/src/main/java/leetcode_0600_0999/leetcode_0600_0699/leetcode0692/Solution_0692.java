package leetcode_0600_0999.leetcode_0600_0699.leetcode0692;

import java.util.*;

/**
 * @author lipan
 * <p>
 * 题目：
 * 692. 前K个高频单词
 * <p>
 * 内容：
 * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
 */
public class Solution_0692 {

    /**
     * 借助 hashMap 和 Sort List 进行解答
     */
    public List<String> topKFrequent(String[] words, int k) {
        // 边界条件
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        // map 存储个数
        Map<String, Integer> map = new HashMap<>();
        // list 存储不同的元素
        List<String> res = new ArrayList<>();
        for (String word : words) {
            Integer cnt = map.getOrDefault(word, 0);
            if (cnt == 0) {
                res.add(word);
            }
            map.put(word, cnt + 1);
        }
        // 对 list 进行排序
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return map.get(word1) == map.get(word2) ? word1.compareTo(word2) : map.get(word2) - map.get(word1);
            }
        });
        return res.subList(0, k);
    }
}
