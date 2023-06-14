/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 24. 反转链表
 * <p>
 * 内容：
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 此题目其他解法：
 * 此题还可以借助栈的先进后出特性进行解答
 */
class Solution_24 {

    /**
     * 原地翻转链表，迭代的解法
     */
    public ListNode reverseListMethod1(ListNode head) {
        // 边界条件
        if (head == null || head.next == null) {
            return head;
        }
        // 声明前指针和当前指针
        ListNode pre = null;
        ListNode cur = head;
        // 遍历
        while (cur != null) {
            // 保存下一结点
            ListNode nxt = cur.next;
            // 当前指针的 next 指向前一个结点
            cur.next = pre;
            // 进入下一结点继续
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    /**
     * 原地翻转链表，递归的解法
     */
    public ListNode reverseListMethod2(ListNode head) {
        return reverse(head, null); // 调用递归并返回
    }

    private ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null) { // 终止条件
            return pre;
        }
        ListNode res = reverse(cur.next, cur); // 递归后继节点
        cur.next = pre; // 修改节点引用指向
        return res; // 返回反转链表的头节点
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