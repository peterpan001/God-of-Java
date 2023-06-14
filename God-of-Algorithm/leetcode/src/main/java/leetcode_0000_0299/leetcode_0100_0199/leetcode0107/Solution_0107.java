package leetcode_0000_0299.leetcode_0100_0199.leetcode0107;

import java.util.*;

/**
 * @author lipan
 * <p>
 * 题目：
 * 107. 二叉树的层序遍历 II
 * <p>
 * 内容：
 * 给你二叉树的根节点root，返回其节点值自底向上的层序遍历。（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class Solution_0107 {

    /**
     * 二叉树的层序遍历借助队列实现
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 边界条件
        if (root == null) {
            return new ArrayList<>();
        }
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 将头结点放入队列
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 取当前队列 size
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                // 左节点不为空，将左节点放入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                // 右节点不为空，将右节点放入队列
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(tmp);
        }
        // 队列反转
        Collections.reverse(result);
        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */