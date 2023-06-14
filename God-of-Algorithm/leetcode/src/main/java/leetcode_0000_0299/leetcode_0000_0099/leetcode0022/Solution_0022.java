package leetcode_0000_0299.leetcode_0000_0099.leetcode0022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lipan
 * <p>
 * 题目：
 * 22. 括号生成
 * <p>
 * 内容：
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Solution_0022 {

    /**
     * 回溯法，此题有一个特点，如果当前字符串中右括号数大于左括号数，则一定不匹配
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        backtracking(n, list, 0, 0, "");
        return list;
    }

    private void backtracking(int n, List<String> list, int left, int right, String str) {
        // 右括号大于左括号数，不匹配直接返回
        if (right > left) {
            return;
        }
        // 左/右括号都为n，则添入结果集中
        if (left == n && right == n) {
            list.add(str);
            return;
        }
        // 左括号数小于n，左括号+1
        if (left < n) {
            backtracking(n, list, left + 1, right, str + "(");
        }
        // 右括号数小于左括号数，右括号+1
        if (right < left) {
            backtracking(n, list, left, right + 1, str + ")");
        }
    }
}
