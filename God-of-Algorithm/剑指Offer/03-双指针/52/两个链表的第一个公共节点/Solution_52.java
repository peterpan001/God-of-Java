/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * <p>
 * 内容：
 * 输入两个链表，找出它们的第一个公共节点。
 */
class Solution_52 {

    /**
     * 定义两个临时节点，分别指向headA和headB
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 边界条件
        if (headA == null || headB == null) {
            return null;
        }
        ListNode head1 = headA;
        ListNode head2 = headB;
        // 要么有相等的节点退出循环，要么都为空退出循环，空的话说明两个链表不相交，没有公共节点
        while (head1 != head2) {
            head1 = head1 == null ? headB : head1.next;
            head2 = head2 == null ? headA : head2.next;
        }
        return head1;
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
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */