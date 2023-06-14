import java.util.Arrays;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 40. 最小的k个数
 * <p>
 * 内容：
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 */
public class Solution_40 {


    /**
     * 先排好序，再取最小的 k 个数
     */
    public int[] getLeastNumbersMethod1(int[] arr, int k) {
        if (arr == null || arr.length < 1) {
            return new int[0];
        }
        // 冒泡排序
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    /**
     * 借助快排的思想解决
     */
    public int[] getLeastNumbersMethod2(int[] arr, int k) {
        if (arr == null || arr.length < 1) {
            return new int[0];
        }
        if (arr.length <= k) {
            return arr;
        }
        return quickSort(arr, 0, arr.length - 1, k);
    }

    private int[] quickSort(int[] arr, int left, int right, int k) {
        int i = left, j = right;
        while (i < j) {
            while (i < j && arr[j] >= arr[left]) {
                j--;
            }
            while (i < j && arr[i] <= arr[left]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, left);
        if (i > k) {
            return quickSort(arr, left, i - 1, k);
        }
        if (i < k) {
            return quickSort(arr, i + 1, right, k);
        }
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}