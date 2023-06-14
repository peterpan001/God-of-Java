/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * <p>
 * 内容：
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 */
public class Solution_54 {

    int target;
    int k;

    /**
     * 二叉搜索树：中序遍历是一个从小到大递增的序列
     */
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        this.k = k;
        inOrder(root);
        return target;
    }

    /**
     * 二叉搜索树：先右在根再左是一个降序排列的数组
     */
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.right);
        if (--this.k == 0) {
            this.target = root.val;
            return;
        }
        inOrder(root.left);
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