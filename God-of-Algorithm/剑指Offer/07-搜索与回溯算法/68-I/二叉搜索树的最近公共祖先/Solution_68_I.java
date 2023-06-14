/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * <p>
 * 内容：
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */
public class Solution_68_I {

    /**
     * 借助递归解决
     * 二叉搜索树：树的左子节点都小于根节点，树的右子节点都大于根节点
     */
    public TreeNode lowestCommonAncestorMethod1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p.val <= root.val && q.val >= root.val || q.val <= root.val && p.val >= root.val) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorMethod1(root.left, p, q);
        }
        return lowestCommonAncestorMethod1(root.right, p, q);
    }

    /**
     * 遍历解决
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        while (root != null) {
            if (p.val <= root.val && q.val >= root.val || q.val <= root.val && p.val >= root.val) {
                return root;
            }
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
        }
        return null;
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