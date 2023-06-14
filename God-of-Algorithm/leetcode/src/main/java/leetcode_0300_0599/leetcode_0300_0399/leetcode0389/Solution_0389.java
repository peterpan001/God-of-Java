package leetcode_0300_0599.leetcode_0300_0399.leetcode0389;

/**
 * @author lipan
 * <p>
 * 题目：
 * 389. 找不同
 * <p>
 * 内容：
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 */
public class Solution_0389 {

    /**
     * 求和，分别算出s字符串和t字符串的ascii和，相减即可得出
     */
    public char findTheDifferenceMethod1(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); i++) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    /**
     * 位运算：找出出现奇数次的那个数
     */
    public char findTheDifferenceMethod2(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            res ^= t.charAt(i);
        }
        return (char) res;
    }

    /**
     * 计算次数
     */
    public char findTheDifferenceMethod3(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < t.length(); i++) {
            cnt[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']--;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 1) {
                return (char) (i + 'a');
            }
        }
        return ' ';
    }
}
