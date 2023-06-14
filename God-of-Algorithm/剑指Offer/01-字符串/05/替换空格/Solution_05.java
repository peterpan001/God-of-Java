/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 05. 替换空格
 * <p>
 * 内容：
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Solution_05 {

    /**
     * 借助 Java 字符缓冲区进行解答
     */
    public String replaceSpaceMethod1(String s) {
        // 边界问题
        if (s == null || s.length() == 0) {
            return null;
        }
        StringBuilder append = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                append.append("%20");
            } else {
                append.append(s.charAt(i));
            }
        }
        return append.toString();
    }

    /**
     * 借助额外空间字符数组进行解答
     */
    public String replaceSpaceMethod2(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int spaceLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                spaceLen++;
            }
        }
        int idx = 0;
        Character[] chs = new Character[s.length() + spaceLen * 2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                chs[idx++] = '%';
                chs[idx++] = '2';
                chs[idx++] = '0';
            } else {
                chs[idx++] = s.charAt(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            sb.append(chs[i]);
        }
        return new String(sb);
    }
}