import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 37. 序列化二叉树
 * <p>
 * 内容：
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列/反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 */
public class Codec {


    // Encodes a tree to a single string.

    /**
     * 将树转化为字符串，借助层序遍历：1,2,3,null,null,4,5
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
                builder.append(node.val + ",");
            } else {
                builder.append("null,");
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.

    /**
     * 还是借助队列层序遍历来实现
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() <= 0) {
            return null;
        }
        String[] split = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);
        int idx = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!split[idx].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(split[idx]));
                node.left = left;
                queue.add(left);
            }
            idx++;
            if (!split[idx].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(split[idx]));
                node.right = right;
                queue.add(right);
            }
            idx++;
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

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));