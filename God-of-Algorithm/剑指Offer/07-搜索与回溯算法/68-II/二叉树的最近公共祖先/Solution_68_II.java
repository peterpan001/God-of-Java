/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * <p>
 * 内容：
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class Solution_68_II {

    /**
     * 二叉树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果 root 为空或者有某一节点值等于 root，则公共祖先即为 root
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // 求左子树中的公共祖先
        TreeNode leftCommonNode = lowestCommonAncestor(root.left, p, q);
        // 求右子树中的公共祖先
        TreeNode rightCommonNode = lowestCommonAncestor(root.right, p, q);
        // 都为空，则不存在
        if (leftCommonNode == null && rightCommonNode == null) {
            return null;
        }
        // 都不为空，则根节点为公共祖先
        if (leftCommonNode != null && rightCommonNode != null) {
            return root;
        }
        // 左子树为空，则右子树为公共节点
        if (leftCommonNode == null) {
            return rightCommonNode;
        }
        // 右子树为空，则左子树为公共节点
        if (rightCommonNode == null) {
            return leftCommonNode;
        }
        // 返回空
        return null;
    }

    public class TreeNode {
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