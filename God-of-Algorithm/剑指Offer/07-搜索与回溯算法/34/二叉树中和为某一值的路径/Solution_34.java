import java.util.ArrayList;
import java.util.List;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * <p>
 * 内容：
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class Solution_34 {

    /**
     * 借助深度遍历实现
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        // 如果树为空，则直接返回
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, target, new ArrayList<>(), res);
        return res;
    }

    /**
     * 深度遍历
     */
    private void dfs(TreeNode root, int target, List<Integer> list, List<List<Integer>> res) {
        // 节点为空，则直接返回
        if (root == null) {
            return;
        }
        // 将元素放入列表中
        list.add(root.val);
        // target 减去当前值
        target = target - root.val;
        // 如果树的左/右节点为空，且 target 为0，则当前路径满足
        if (root.left == null && root.right == null && target == 0) {
            // 注意此处，对象的复制
            res.add(new ArrayList<>(list));
        }
        // 递归遍历树的左节点
        dfs(root.left, target, list, res);
        // 递归遍历树的右节点
        dfs(root.right, target, list, res);
        // 回溯
        list.remove(list.size() - 1);
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