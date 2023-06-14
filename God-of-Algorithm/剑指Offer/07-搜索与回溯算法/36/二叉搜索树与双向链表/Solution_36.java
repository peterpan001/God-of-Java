import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * <p>
 * 内容：
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class Solution_36 {

    /**
     * 二叉搜索树的中序遍历是一个排序的数组，且由小从大排列
     */
    public Node treeToDoublyList(Node root) {
        // 如果节点为空，则直接返回
        if (root == null) {
            return null;
        }
        // 借助队列来存放元素，队列有先进先出特性
        Queue<Node> queue = new LinkedList<>();
        // 中序遍历
        inOrder(root, queue);
        // 队列第一个元素作为头结点
        Node head = queue.poll();
        Node pre = head;
        // 队列不为空，一直循环
        while (!queue.isEmpty()) {
            // 获取当前节点
            Node cur = queue.poll();
            // 将前节点的右指针指向当前节点
            pre.right = cur;
            // 将当前节点的左指针指向前节点
            cur.left = pre;
            // 前节点转换为当前节点继续
            pre = cur;
        }
        // pre 退出时为尾节点，尾节点右指针指向头结点，头节点左指针指向尾节点
        pre.right = head;
        head.left = pre;
        return head;
    }

    /**
     * 中序遍历二叉搜索树
     */
    private void inOrder(Node root, Queue<Node> queue) {
        if (root == null) {
            return;
        }
        // 遍历左节点
        inOrder(root.left, queue);
        // 遍历根节点
        queue.add(root);
        // 遍历右节点
        inOrder(root.right, queue);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

}

/**
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public Node left;
 * public Node right;
 * <p>
 * public Node() {}
 * <p>
 * public Node(int _val) {
 * val = _val;
 * }
 * <p>
 * public Node(int _val,Node _left,Node _right) {
 * val = _val;
 * left = _left;
 * right = _right;
 * }
 * };
 */