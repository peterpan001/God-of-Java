import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * <p>
 * 内容：
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class Solution_32_I {

    /**
     * 层序遍历二叉树
     */
    public int[] levelOrder(TreeNode root) {
        // 如果树为空，直接返回空数组
        if (root == null) {
            return new int[0];
        }
        // 借助队列来实现层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // list 存在层序遍历结果
        List<Integer> list = new ArrayList<>();
        // 节点进队列
        queue.add(root);
        // 队列不为空，一直循环
        while (!queue.isEmpty()) {
            // 节点出队列
            TreeNode node = queue.poll();
            // 将值放入 list 中
            list.add(node.val);
            // 队列左节点不为空，则将左节点放入队列
            if (node.left != null) {
                queue.add(node.left);
            }
            // 队列右节点不为空，则将右节点放入队列
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        // 将链表的值放入数组中
        int[] res = new int[list.size()];
        int idx = 0;
        for (Integer integer : list) {
            res[idx++] = integer;
        }
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */