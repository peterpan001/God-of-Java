import java.util.Stack;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 27. 二叉树的镜像
 * <p>
 * 内容：
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Solution_27 {

    /**
     * 借助递归进行解决
     */
    public TreeNode mirrorTreeMethod1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        // 获取左子树
        TreeNode left = mirrorTreeMethod1(root.left);
        // 获取右子树
        TreeNode right = mirrorTreeMethod1(root.right);
        // 将右子树赋值给根节点的左子节点
        root.left = right;
        // 将左子树赋值给根节点的右子节点
        root.right = left;
        return root;
    }

    /**
     * 借助栈来解答
     */
    public TreeNode mirrorTreeMethod2(TreeNode root) {
        // 空树或者只有根节点的树，直接返回
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 根节点进栈
        stack.push(root);
        // 栈不为空，进行交换
        while (!stack.isEmpty()) {
            // 获取当前栈节点
            TreeNode node = stack.pop();
            // 获取当前节点左右节点
            TreeNode left = node.left;
            TreeNode right = node.right;
            // 左右节点交换
            node.left  = right;
            node.right = left;
            // 子节点不为空继续进栈
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
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