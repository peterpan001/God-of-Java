package leetcode_0600_0999.leetcode_0900_0999.leetcode0938;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lipan
 * <p>
 * 题目：
 * 938. 二叉搜索树的范围和
 * <p>
 * 内容：
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
public class Solution_0938 {

    /**
     * 递归解决，借助二叉搜索树的特性，对于任意一个节点，其左子树都小于此节点，其右子树都大于此节点
     */
    public int rangeSumBST1(TreeNode root, int low, int high) {
        // 边界条件
        if (root == null) {
            return 0;
        }
        // 如果根节点大于 high，则看左子树
        if (root.val > high) {
            return rangeSumBST1(root.left, low, high);
        }
        // 如果根节点小于 low，则看右子树
        if (root.val < low) {
            return rangeSumBST1(root.right, low, high);
        }
        return root.val + rangeSumBST1(root.left, low, high) + rangeSumBST1(root.right, low, high);
    }

    /**
     * 层次遍历，广度优先遍历
     */
    public int rangeSumBST2(TreeNode root, int low, int high) {
        // 边界条件
        if (root == null) {
            return 0;
        }
        int result = 0;
        // 借助队列实现层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val >= low && node.val <= high) {
                result += node.val;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    public class TreeNode {
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
