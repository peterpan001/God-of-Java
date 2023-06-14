import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * <p>
 * 内容：
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution_39 {

    /**
     * 借助 hashMap 实现
     */
    public int majorityElementMethod1(int[] nums) {
        // 边界判断
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }

    /**
     * 计数法实现
     */
    public int majorityElementMethod2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                res = nums[i];
                cnt = 1;
            } else {
                if (res == nums[i]) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }
        return res;
    }
}