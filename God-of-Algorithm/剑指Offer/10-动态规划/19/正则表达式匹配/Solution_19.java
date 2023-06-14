/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 19. 正则表达式匹配
 * <p>
 * 内容：
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
public class Solution_19 {

    public boolean isMatch(String s, String p) {
        // p 是空，s也为空，则两个匹配
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // 看第一个字符是否匹配，两种情况：第一种两个字符相等，第二种p的第一个字符是点
        boolean first_match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        // 看p的长度是否大于2且第二个字符是否为星
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // s 整个串和p的第三个字符开始比较即：p为.*xxxx，即s第一个字符和第二个字符都和p不相同
            // s 整个串和p的第一个字符相同，p的第二个是星：即：p为a*xxxx，s为asssxxxxx
            return isMatch(s, p.substring(2)) || first_match && isMatch(s.substring(1), p);
        } else {
            // 第一个字符相等，开始比较第二个
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}