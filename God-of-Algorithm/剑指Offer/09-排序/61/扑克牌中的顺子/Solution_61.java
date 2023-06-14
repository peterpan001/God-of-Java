import java.util.HashSet;
import java.util.Set;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 61. 扑克牌中的顺子
 * <p>
 * 内容：
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，
 * K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class Solution_61 {

    /**
     * 要想连成顺子，最大的牌和最小的牌之差要小于5才可以
     */
    public boolean isStraight(int[] nums) {
        // 如果扑克不够五张，直接返回
        if (nums == null || nums.length < 5) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Integer min = 13;
        Integer max = 0;
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (set.add(nums[i])) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            } else {
                return false;
            }
        }
        return max - min < 5;
    }
}