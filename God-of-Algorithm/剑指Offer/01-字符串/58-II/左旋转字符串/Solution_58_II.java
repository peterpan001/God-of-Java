/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 58 - II. 左旋转字符串
 * <p>
 * 内容：
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class Solution_58_II {
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0) { // 边界条件
            return null;
        }
        StringBuilder str = new StringBuilder();
        // 遍历字符串进行拼接，注意 i 遍历的长度是一个巧妙的地方
        for (int i = n; i < s.length() + n; i++) {
            str.append(s.charAt(i % s.length()));
        }
        return str.toString();
    }
}