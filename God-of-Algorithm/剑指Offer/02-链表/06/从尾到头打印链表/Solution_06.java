import java.util.Stack;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 06. 从尾到头打印链表
 * <p>
 * 内容：
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Solution_06 {

    /**
     * 遍历链表，元素倒放
     */
    public int[] reversePrintMethod1(ListNode head) {
        // 边界
        if (head == null) {
            return new int[0];
        }
        // 获取链表长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        // 初始化数组长度
        int[] res = new int[len];
        len--;
        cur = head;
        // 遍历链表，将元素从右向左放入数组中
        while (cur != null) {
            res[len--] = cur.val;
            cur = cur.next;
        }
        return res;
    }

    /**
     * 借助栈的先进后出属性实现链表从尾到头打印
     */
    public int[] reversePrintMethod2(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<Integer>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] res = new int[stack.size()];
        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }
        return res;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */