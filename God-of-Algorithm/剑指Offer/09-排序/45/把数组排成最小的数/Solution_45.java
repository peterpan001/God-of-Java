import java.util.Arrays;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 45. 把数组排成最小的数
 * <p>
 * 内容：
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class Solution_45 {

    /**
     * 借助字符串比较函数得来：a + b > b + a，那么就是：ab，借助此比较思想进行快排
     */
    public String minNumberMethod1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return "";
        }
        String[] res = new String[nums.length];
        int idx = 0;
        for (int num : nums) {
            res[idx++] = String.valueOf(num);
        }
        Arrays.sort(res, (x, y) -> {
            return (x + y).compareTo(y + x);
        });
        StringBuilder builder = new StringBuilder();
        for (String re : res) {
            builder.append(re);
        }
        return builder.toString();
    }

    /**
     * 不借助内置的快排思想，自己实现一个快排比较
     */
    public String minNumberMethod2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return "";
        }
        String[] res = new String[nums.length];
        int idx = 0;
        for (int num : nums) {
            res[idx++] = String.valueOf(num);
        }
        quickSort(res, 0, res.length - 1);
        StringBuilder builder = new StringBuilder();
        for (String re : res) {
            builder.append(re);
        }
        return builder.toString();
    }

    private void quickSort(String[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        while (i < j) {
            while (i < j && (nums[j] + nums[left]).compareTo(nums[left] + nums[j]) >= 0) {
                j--;
            }
            while (i < j && (nums[i] + nums[left]).compareTo(nums[left] + nums[i]) <= 0) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, left, i);
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    private void swap(String[] nums, int i, int j) {
        String tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}