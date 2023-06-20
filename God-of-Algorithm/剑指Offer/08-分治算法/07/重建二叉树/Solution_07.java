import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 07. 重建二叉树
 * <p>
 * 内容：
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
class Solution_07 {

    Map<Integer, Integer> hashMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        hashMap = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1 && l2 > r2) {
            return null;
        }
        // 前序遍历的头节点即为根节点
        TreeNode root = new TreeNode(preorder[l1]);
        // 获取根节点在中序遍历的位置
        int i = hashMap.get(preorder[l1]);
        // 根的左子树节点为：前序遍历的 l1 + 1 到 l1 + (i - l2); 中序遍历为：l2 到 i - 1
        root.left = buildTree(preorder, l1 + 1, l1 + (i - l2), inorder, l2, i - 1);
        // 根的右子树节点为：前序遍历的 l1 + (i - l2) + 1 到 r1; 中序遍历为：i + 1 到 r2
        root.right = buildTree(preorder, l1 + (i - l2) + 1, r1, inorder, i + 1, r2);
        // 返回根节点
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