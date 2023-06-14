import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * <p>
 * 内容：
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class Solution_56_II {
    /**
     * 借助 hashMap 去实现，现实中更推荐此法
     */
    public int singleNumberMethod1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int singleNumberMethod2(int[] nums) {
        // 边界判断
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 记录32位数字
        int[] res = new int[32];
        int m = 1;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & m) != 0) {
                    res[i]++;
                }
            }
            res[i] = res[i] % 3;
            sum = sum + res[i] * m;
            // m 右移一位
            m = m << 1;
        }
        return sum;
    }
}