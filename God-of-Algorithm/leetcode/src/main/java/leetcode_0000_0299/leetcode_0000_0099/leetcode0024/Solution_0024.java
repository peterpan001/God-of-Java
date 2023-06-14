
/**
 * @author lipan
 * <p>
 * 题目：
 * 24. 两两交换链表中的节点
 * <p>
 * 内容：
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题
 * （即，只能进行节点交换）。
 */
public class Solution_0024 {

    // 迭代法
    public ListNode swapPairs(ListNode head) {
        // 边界
        if (head == null || head.next == null) {
            return head;
        }
        // 声明一个头结点指针，它的 next 指向头结点
        ListNode res = new ListNode(0);
        res.next = head;
        // 指向头结点
        ListNode cur = res;
        while (head != null && head.next != null) {
            // 存储头结点的 next 节点
            ListNode next = head.next;
            // 存储 next 节点的 next 节点
            ListNode tmp = head.next.next;
            // 将头结点的 next 指针指向 next；
            cur.next = next;
            // 将 next 的 next 指针指向头结点
            next.next = head;
            // 将头结点的next指针指向tmp
            head.next = tmp;
            // cur 指向 head节点
            cur = head;
            // head 指向 head 的 next
            head = head.next;
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