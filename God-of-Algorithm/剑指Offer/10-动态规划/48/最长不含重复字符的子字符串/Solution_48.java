import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * <p>
 * 内容：
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class Solution_48 {

    public int lengthOfLongestSubstring(String s) {
        // 边界处理
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 借助 map 存储各个字符串的下标位置
        Map<Character, Integer> map = new HashMap<>();
        // dp[i]：用于存储以当前位置s.charAt(i)为结尾的最长不重复子串长度
        int[] dp = new int[s.length()];
        map.put(s.charAt(0), 0);
        int res = 1;
        for (int i = 1; i < s.length(); i++) {
            // 如果map中不存在此字符，则dp[i]的长度为dp[i-1]+1
            if (!map.containsKey(s.charAt(i))) {
                dp[i] = dp[i - 1] + 1;
            } else {
                // 如果 map 中存在此字符，则dp[i]的长度为下面的公式：
                int k = map.get(s.charAt(i));
                dp[i] = i - k <= dp[i - 1] ? i - k : dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
            map.put(s.charAt(i), i);
        }
        return res;
    }
}