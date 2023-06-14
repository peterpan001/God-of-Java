/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * <p>
 * 内容：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class Solution_33 {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right) { // 如果左指针大于等于右指针，说明已经校验完毕，满足后续二叉搜索树的要求
            return true;
        }
        int rootVal = postorder[right]; // 获取二叉搜索树的跟节点值
        int mid = left; // 查找二叉搜索树的右孩子节点下标
        while (postorder[mid] < rootVal) {
            mid++;
        }
        int tmp = mid; // 二叉搜索树的右孩子第一个元素下标
        while (tmp < right) {
            if (postorder[tmp] < postorder[right]) { // 二叉搜索树的右孩子都会大于根节点值，如果小于则不满足二叉搜索树
                return false;
            }
            tmp++;
        }
        // 递归的遍历以根节点左右孩子为根节点的左右子树是否满足二叉搜索树
        return verifyPostorder(postorder, left, mid - 1) && verifyPostorder(postorder, mid, right - 1);
    }
}