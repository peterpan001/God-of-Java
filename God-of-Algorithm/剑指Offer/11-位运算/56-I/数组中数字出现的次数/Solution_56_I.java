import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * <p>
 * 内容：
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class Solution_56_I {

    /**
     * 最直接的方法，即借助O(n)的空间去找
     */
    public int[] singleNumbersMethod1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] res = new int[2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }

    /**
     * 借助位移操作进行解决
     */
    public int[] singleNumbersMethod2(int[] nums) {
        int x = 0, y = 0;
        int n = 0, m = 1;
        // 此时 n 即为 nums 中两个不同的数的异或的结果
        for (int num : nums) {
            n = n ^ num;
        }
        // 找到其中一个不同的异位 1
        while ((n & m) == 0) {
            m <<= 1;
        }
        // 借助m将两个不同的数组分为两部分，分别会找到那两个不同的数
        for (int num : nums) {
            if ((num & m) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}