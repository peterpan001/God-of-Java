package leetcode_0000_0299.leetcode_0200_0299.leetcode0234;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lipan
 * <p>
 * 题目：
 * 234. 回文链表
 * <p>
 * 内容：
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true；否则，返回 false。
 */
public class Solution_0234 {

    /**
     * 双指针法
     */
    public boolean isPalindromeMethod1(ListNode head) {
        // 边界条件
        if (head == null || head.next == null) {
            return true;
        }
        // 将链表元素存储在数组中
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        // 声明左/右指针开始比对
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 递归法
     */
    ListNode cur;

    public boolean isPalindromeMethod2(ListNode head) {
        // 边界条件
        if (head == null || head.next == null) {
            return true;
        }
        cur = head;
        // 递归
        return recursion(head);
    }

    private boolean recursion(ListNode head) {
        // 如果为空，则返回true
        if (head == null) {
            return true;
        }
        // 如果递归下去不为空，则返回false
        if (!recursion(head.next)) {
            return false;
        }
        // 比较cur结点和尾节点是否相等，不想等返回false，否则cur结点指针下移一步，返回true
        if (cur.val != head.val) {
            return false;
        }
        cur = cur.next;
        return true;
    }

    /**
     * 栈解法
     */
    public boolean isPalindromeMethod3(ListNode head) {
        // 边界条件
        if (head == null || head.next == null) {
            return true;
        }
        // 声明栈存储链表所有元素
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.add(cur.val);
            cur = cur.next;
        }
        cur = head;
        // 借助栈的先进后出特点，比较此链表是否为回文链表
        while (!stack.isEmpty()) {
            Integer val = stack.pop();
            if (val != cur.val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */