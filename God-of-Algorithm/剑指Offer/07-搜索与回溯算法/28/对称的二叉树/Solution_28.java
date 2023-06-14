/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 28. 对称的二叉树
 * <p>
 * 内容：
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class Solution_28 {

    public boolean isSymmetric(TreeNode root) {
        // 如果树为空，或者只有根节点的树则位对称二叉树
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        // 深度遍历
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode nodeA, TreeNode nodeB) {
        // 如果节点都为空，则为对称
        if (nodeA == null && nodeB == null) {
            return true;
        }
        // 如果有一个为空，则为不对称
        if (nodeA == null || nodeB == null) {
            return false;
        }
        // 值不想等，则为不对称
        if (nodeA.val != nodeB.val) {
            return false;
        }
        // 否则递归遍历看a的左节点和b的右节点，a的右节点和b的左节点
        return dfs(nodeA.left, nodeB.right) && dfs(nodeA.right, nodeB.left);
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