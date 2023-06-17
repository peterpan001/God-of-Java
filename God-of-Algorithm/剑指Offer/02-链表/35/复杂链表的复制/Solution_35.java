import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 35. 复杂链表的复制
 * <p>
 * 内容：
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class Solution_35 {

    /**
     * 原地复制
     */
    public Node copyRandomListMethod1(Node head) {
        // 边界条件
        if (head == null) {
            return null;
        }
        Node cur = head;
        // 复制 next 结点
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 复制 random 节点
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 拆分链表，利用两个头结点，分别指向两个链表的头，进行断开即可
        cur = head.next;
        Node pre = head;
        Node newHead = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            pre = pre.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        pre.next = null;
        return newHead;
    }

    /**
     * 借助 HashMap 开辟额外空间进行复制
     */
    public Node copyRandomListMethod2(Node head) {
        // 边界条件
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 第一次遍历链表，先复制出所有结点
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 第二次遍历链表，给所有节点赋予 next 指针和 random 指针
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 返回头结点
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/