/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 18. 删除链表的节点
 * <p>
 * 内容：
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 */
class Solution_18 {

    /**
     * 遍历链表删除元素即可
     */
    public ListNode deleteNodeMethod1(ListNode head, int val) {
        if (head == null) { // 边界问题
            return null;
        }
        if (head.val == val) { // 删除的是头节点
            return head.next;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == val && cur.next != null) { // 删除是链表中间节点
                pre.next = cur.next;
                return head;
            } else if (cur.val == val && cur.next == null) { // 删除是链表尾部节点
                pre.next = null;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    /**
     * 上述优化：遍历链表即可，分两种情况：删除是头节点，删除是非头节点
     */
    public ListNode deleteNodeMethod2(ListNode head, int val) {
        // 链表为空
        if (head == null) {
            return head;
        }
        // 删除的节点是链表头节点
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            // 删除的节点是链表的中间节点或者尾部节点，统称为非头部节点
            if (cur.val == val) {
                pre.next = cur.next;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }

        return head;
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