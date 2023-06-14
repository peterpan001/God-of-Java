package leetcode_0000_0299.leetcode_0000_0099.leetcode0021;

/**
 * @author lipan
 * <p>
 * 题目：
 * 21. 合并两个有序链表
 * <p>
 * 内容：
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Solution_0021 {

    /**
     * 迭代法解决，循环遍历两个链表，并比较元素值大小
     */
    public ListNode mergeTwoListsMethod1(ListNode list1, ListNode list2) {
        // 边界条件
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode res = new ListNode(0);
        ListNode head = res;
        // 循环遍历两个链表，并修改链表尾节点指针
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        // list1 不为空时
        if (list1 != null) {
            res.next = list1;
        }
        // list2 不为空时
        if (list2 != null) {
            res.next = list2;
        }
        return head.next;
    }

    /**
     * 递归法解决
     */
    public ListNode mergeTwoListsMethod2(ListNode list1, ListNode list2) {
        // 边界条件
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        // 如果 l1.val > l2.val，l2 为头，否则 l1 为头
        if (list1.val > list2.val) {
            list2.next = mergeTwoListsMethod2(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoListsMethod2(list1.next, list2);
            return list1;
        }
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
