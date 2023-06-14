package leetcode_0000_0299.leetcode_0000_0099.leetcode0002;

/**
 * @author lipan
 * <p>
 * 题目：
 * 2. 两数相加
 * <p>
 * 内容：
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Solution_0002 {

    /**
     * 迭代法解决
     */
    public ListNode addTwoNumbersMethod1(ListNode l1, ListNode l2) {
        // 边界条件
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int nextVal = 0;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + nextVal;
            nextVal = val / 10;
            cur.next = new ListNode(val % 10);
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while (l1 != null) {
            int val = l1.val + nextVal;
            nextVal = val / 10;
            cur.next = new ListNode(val % 10);
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            int val = l2.val + nextVal;
            nextVal = val / 10;
            cur.next = new ListNode(val % 10);
            l2 = l2.next;
            cur = cur.next;
        }
        if (nextVal != 0) {
            cur.next = new ListNode(nextVal);
        }
        return res.next;
    }


    /**
     * 迭代法优化
     */
    public ListNode addTwoNumbersMethod2(ListNode l1, ListNode l2) {
        // 边界条件
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int nextVal = 0;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int val = val1 + val2 + nextVal;
            cur.next = new ListNode(val % 10);
            nextVal = val / 10;
            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if (nextVal != 0) {
            cur.next = new ListNode(nextVal);
        }
        return res.next;
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
