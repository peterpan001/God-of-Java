package leetcode_0000_0299.leetcode_0000_0099.leetcode0020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author lipan
 * <p>
 * 题目：
 * 20. 有效的括号
 * <p>
 * 内容：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 3.每个右括号都有一个对应的相同类型的左括号。
 */
public class Solution_0020 {

    /**
     * 借助栈来实现
     */
    public boolean isValidMethod1(String s) {
        // 边界条件判断
        if (s == null || s.length() % 2 == 1 || s.length() == 0) {
            return false;
        }
        // 将字符串转化为字符数组
        char[] chars = s.toCharArray();
        // 声明栈
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        // 遍历栈元素
        while (idx < chars.length) {
            // 如果栈为空，且元素为右括号表明不匹配直接返回，否则进栈
            if (stack.isEmpty()) {
                if (chars[idx] == ')' || chars[idx] == '}' || chars[idx] == ']') {
                    return false;
                }
                stack.push(chars[idx]);
            } else {
                // 如果遇到左括号，则直接进栈
                if (chars[idx] == '(' || chars[idx] == '{' || chars[idx] == '[') {
                    stack.push(chars[idx]);
                } else {
                    // 此时字符为右括号
                    Character peek = stack.peek();
                    // 如果栈顶匹配为小的左括号，大括号，中括号则栈顶元素出栈，否则代表不匹配，直接返回false
                    if (peek == '(' && chars[idx] == ')') {
                        stack.pop();
                    } else if (peek == '{' && chars[idx] == '}') {
                        stack.pop();
                    } else if (peek == '[' && chars[idx] == ']') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            idx++;
        }
        return stack.isEmpty();
    }


    /**
     * 栈方法的优化，借助 HashMap 的空间大小
     */
    public boolean isValidMethod2(String s) {
        // 边界条件判断
        if (s == null || s.length() % 2 == 1 || s.length() == 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    /**
     * 利用字符串特性
     */
    public boolean isValidMethod3(String s) {
        // 边界条件判断
        if (s == null || s.length() % 2 == 1 || s.length() == 0) {
            return false;
        }
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            }
            if (s.contains("[]")) {
                s = s.replace("[]", "");
            }
            if (s.contains("{}")) {
                s = s.replace("{}", "");
            }
        }
        return s.length() == 0;
    }
}
