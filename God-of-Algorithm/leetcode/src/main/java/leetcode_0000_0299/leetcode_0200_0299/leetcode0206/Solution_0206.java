package leetcode_0000_0299.leetcode_0200_0299.leetcode0206;

import java.util.Stack;

/**
 * @author lipan
 * <p>
 * 题目：
 * 206. 反转链表
 * <p>
 * 内容：
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Solution_0206 {

    /**
     * 递归法
     */
    public ListNode reverseListMethod1(ListNode head) {
        // 边界条件
        if (head == null || head.next == null) {
            return head;
        }
        // 反转 head 的下一个节点
        ListNode res = reverseListMethod1(head.next);
        // 将头结点的next节点的next指针指向head
        head.next.next = head;
        // 将 head的next指针指向null
        head.next = null;
        return res;
    }

    /**
     * 迭代法
     */
    public ListNode reverseListMethod2(ListNode head) {
        // 边界条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 借助额外 O(n) 空间进行反转
     */
    public ListNode reverseListMethod3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while (!stack.isEmpty()) {
            ListNode tmp = new ListNode(stack.pop());
            cur.next = tmp;
            cur = cur.next;
        }
        return newHead.next;
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
