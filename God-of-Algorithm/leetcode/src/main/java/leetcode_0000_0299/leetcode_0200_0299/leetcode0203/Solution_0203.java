package leetcode_0000_0299.leetcode_0200_0299.leetcode0203;

/**
 * @author lipan
 * <p>
 * 题目：
 * 203. 移除链表元素
 * <p>
 * 内容：
 * 给你一个链表的头节点head和一个整数val ，请你删除链表中所有满足Node.val == val的节点，并返回新的头节点。
 */
public class Solution_0203 {

    /**
     * 添加虚拟头结点
     */
    public ListNode removeElements(ListNode head, int val) {
        // 边界条件
        if (head == null) {
            return null;
        }
        // 声明虚拟头结点，并将其next指针指向 head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 声明游标指针
        ListNode prev = dummy;
        while (prev.next != null) {
            // 移除相同元素链表节点
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }

    public class ListNode {
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