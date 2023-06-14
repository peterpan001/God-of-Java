package leetcode_0300_0599.leetcode_0400_0499.leetcode0496;

/**
 * @author lipan
 * <p>
 * 题目：
 * 496. 下一个更大元素 I
 * <p>
 * 内容：
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * <p>
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * <p>
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * <p>
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素
 */
public class Solution_0496 {

    /**
     * 利用两层循环解决问题
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        boolean flag = false;
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    flag = true;
                    continue;
                }
                if (flag && nums1[i] < nums2[j]) {
                    res[i] = nums2[j];
                    break;
                }
            }
            flag = false;
            if (res[i] == 0) {
                res[i] = -1;
            }
        }
        return res;
    }
}
