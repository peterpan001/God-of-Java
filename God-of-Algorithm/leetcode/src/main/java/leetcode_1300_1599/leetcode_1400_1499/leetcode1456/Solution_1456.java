package leetcode_1300_1599.leetcode_1400_1499.leetcode1456;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lipan
 * <p>
 * 题目：
 * 1456. 定长子串中元音的最大数目
 * <p>
 * 内容：
 * 给你字符串 s 和整数 k 。
 * <p>
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * <p>
 * 英文中的 元音字母 为（a, e, i, o, u）。
 */
public class Solution_1456 {

    /**
     * 滑动窗口的思想
     */
    public int maxVowels(String s, int k) {
        // 边界条件
        if (s == null || s.length() == 0 || s.length() < k) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int maxCnt = 0;
        // 先初始化窗口大小 k
        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))) {
                maxCnt++;
            }
        }
        int tmpCnt = maxCnt;
        // 开始滑动
        for (int i = k; i < s.length(); i++) {
            if (set.contains(s.charAt(i - k))) {
                tmpCnt--;
            }
            if (set.contains(s.charAt(i))) {
                tmpCnt++;
            }
            maxCnt = Math.max(maxCnt, tmpCnt);
        }
        return maxCnt;
    }
}
