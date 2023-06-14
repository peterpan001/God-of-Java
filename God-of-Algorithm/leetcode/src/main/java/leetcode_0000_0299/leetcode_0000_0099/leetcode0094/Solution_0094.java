package leetcode_0000_0299.leetcode_0000_0099.leetcode0094;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lipan
 * <p>
 * 题目：
 * 94. 二叉树的中序遍历
 * <p>
 * 内容：
 * 给定一个二叉树的根节点 root ，返回它的中序遍历 。
 */
public class Solution_0094 {

    List<Integer> result = new ArrayList<>();

    /**
     * 利用递归解决
     */
    public List<Integer> inorderTraversalMethod1(TreeNode root) {
        inorderTree(root);
        return result;
    }

    private void inorderTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTree(root.left);
        result.add(root.val);
        inorderTree(root.right);
    }

    /**
     * 中序遍历，利用栈解决：左根右
     */
    public List<Integer> inorderTraversalMethod2(TreeNode root) {
        // 边界条件
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        // 声明 cur 指向根节点
        TreeNode cur = root;
        // 声明栈，利用栈的先进后出特点
        Stack<TreeNode> stack = new Stack<>();
        // 如果当前节点不为空，或者栈不为空
        while (cur != null || !stack.isEmpty()) {
            // 当前节点不为空，一直进栈树的左节点
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 出栈左节点及左节点根节点
            cur = stack.pop();
            // 添加进list
            list.add(cur.val);
            // 查看右节点
            cur = cur.right;
        }
        return list;
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
