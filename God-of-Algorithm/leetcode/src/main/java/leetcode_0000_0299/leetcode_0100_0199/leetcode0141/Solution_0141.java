package leetcode_0000_0299.leetcode_0100_0199.leetcode0141;

/**
 * @author lipan
 * <p>
 * 题目：
 * 141. 环形链表
 * <p>
 * 内容：
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */
public class Solution_0141 {

    /**
     * 定义快慢指针解决问题
     */
    public boolean hasCycle(ListNode head) {
        // 边界条件
        if (head == null || head.next == null) {
            return false;
        }
        // 定义快慢指针，快指针走两步，慢指针走一步，看快慢指针是否可以重合
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */