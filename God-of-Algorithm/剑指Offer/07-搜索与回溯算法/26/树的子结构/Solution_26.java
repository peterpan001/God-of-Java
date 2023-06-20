/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 26. 树的子结构
 * <p>
 * 内容：
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 */
class Solution_26 {

    /**
     *
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 如果树A为空或者树B为空，则返回 false
        if (A == null || B == null) {
            return false;
        }
        // 递归遍历比较A 和 B，递归遍历A的左子树和B，递归遍历A的右子树和B，有一个符合就返回
        return isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 递归遍历A树和B树的各个节点，看A树和B树是否相等
     */
    private boolean isSubTree(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
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