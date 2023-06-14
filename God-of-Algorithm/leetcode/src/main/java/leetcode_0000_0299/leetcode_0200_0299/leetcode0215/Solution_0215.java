package leetcode_0000_0299.leetcode_0200_0299.leetcode0215;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author lipan
 * <p>
 * 题目：
 * 215. 数组中的第K个最大元素
 * <p>
 * 内容：
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Solution_0215 {


    /**
     * 排序后取第k大元素
     */
    public int findKthLargestMethod1(int[] nums, int k) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 排序
        Arrays.sort(nums);
        // 取出第k大元素
        return nums[nums.length - k];
    }

    /**
     * 堆排序法，使用最小堆，堆顶元素最小
     */
    public int findKthLargestMethod2(int[] nums, int k) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * 快速排序法
     */
    public int findKthLargestMethod3(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int l, int r, int k) {
        int idx = randomPartition(nums, l, r);
        if (idx == k - 1) {
            return nums[idx];
        } else {
            return idx > k - 1 ? quickSort(nums, l, idx - 1, k) : quickSort(nums, idx + 1, r, k);
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        int i = (int) (Math.random() * (r - l)) + l;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int rightmost = r;
        while (l <= r) {
            while (l <= r && nums[l] > pivot) {
                l++;
            }
            while (l <= r && nums[r] <= pivot) {
                r--;
            }
            if (l <= r) {
                swap(nums, l, r);
            }
        }
        swap(nums, l, rightmost);
        return l;
    }
}
