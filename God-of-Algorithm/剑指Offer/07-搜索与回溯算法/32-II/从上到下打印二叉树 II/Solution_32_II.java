import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * <p>
 * 内容：
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class Solution_32_II {

    /**
     * 层序遍历二叉树
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 边界条件
        if (root == null) {
            return new ArrayList<>();
        }
        // 声明队列辅助进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // res 存放结果
        List<List<Integer>> res = new ArrayList<>();
        // 节点进队列
        queue.add(root);
        // 队列不为空，一直循环
        while (!queue.isEmpty()) {
            // 获取当前队列大小
            int size = queue.size();
            // list 用于存放每一层结果
            List<Integer> list = new ArrayList<>();
            // 当前层次的节点全部出队列
            while (size-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 将当前层次队列元素放入结果集中
            res.add(list);
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