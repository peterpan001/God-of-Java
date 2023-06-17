import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 50. 第一个只出现一次的字符
 * <p>
 * 内容：
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class Solution_50 {


    /**
     * 此处借助有序的 hashMap 来进行解答
     */
    public char firstUniqChar(String s) {
        // 边界条件
        if (s == null || s.length() == 0) {
            return ' ';
        }
        // 此处借助 LinkedHashMap 来进行解答即可
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}