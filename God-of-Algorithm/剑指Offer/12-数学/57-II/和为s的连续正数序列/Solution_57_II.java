import java.util.ArrayList;
import java.util.List;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * <p>
 * 内容：
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class Solution_57_II {

    /**
     * 利用快慢指针来解决
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int i = 1, j = 1;
        int sum = 1;
        while (i <= target / 2) {
            if (sum < target) {
                j++;
                sum += j;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] tmp = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    tmp[k - i] = k;
                }
                res.add(tmp);
                sum -= i;
                i++;
                j++;
                sum += j;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}