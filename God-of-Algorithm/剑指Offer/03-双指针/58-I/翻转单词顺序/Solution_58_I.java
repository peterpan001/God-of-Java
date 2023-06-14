/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 58 - I. 翻转单词顺序
 * <p>
 * 内容：
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
class Solution_58_I {

    /**
     * 此题借助了 Java 的特性进行解答，也可以遍历字符进行解决
     */
    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder append = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            // 注意点
            if (s1[i].equals("")) { // 遇到空单词则跳过
                continue;
            }
            append.append(s1[i]).append(" "); // 将单词拼接至 StringBuilder
        }
        return append.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }
}