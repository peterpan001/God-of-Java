package leetcode_0300_0599.leetcode_0300_0399.leetcode0344;

/**
 * @author lipan
 * <p>
 * 题目：
 * 344. 反转字符串
 * <p>
 * 内容：
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class Solution_0344 {

    /**
     * 递归法
     */
    public void reverseStringMethod1(char[] s) {
        recursion(s, 0, s.length - 1);
    }

    private void recursion(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
        recursion(s, left + 1, right - 1);
    }

    /**
     * 双指针法
     */
    public void reverseStringMethod2(char[] s) {
        if (s == null || s.length == 0 || s.length == 1) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
