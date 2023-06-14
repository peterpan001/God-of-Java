/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 51. 数组中的逆序对
 * <p>
 * 内容：
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，
 * 求出这个数组中的逆序对的总数。
 */
public class Solution_51 {


    /**
     * 借助冒泡排序来做，但是当 nums 数组的长度太大时，因O(n^2)的时间复杂度导致超时
     */
    public int reversePairsMethod1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 借助归并排序来做
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 归并排序
     */
    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int x1 = mergeSort(nums, left, mid);
        int x2 = mergeSort(nums, mid + 1, right);
        int x3 = mergeSort(nums, left, mid, mid + 1, right);
        return x1 + x2 + x3;
    }

    private int mergeSort(int[] nums, int l1, int r1, int l2, int r2) {
        int[] tmp = new int[r2 - l1 + 1];
        int count = 0;
        int i = l1, j = l2, k = 0;
        while (i <= r1 && j <= r2) {
            if (nums[i] > nums[j]) {
                count += l2 - i;
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }
        while (i <= r1) {
            tmp[k++] = nums[i++];
        }
        while (j <= r2) {
            tmp[k++] = nums[j++];
        }
        // 把临时数组复制回原数组
        k = 0;
        for (i = l1; i <= r2; i++) {
            nums[i] = tmp[k++];
        }
        return count;
    }
}