package leetcode_0000_0299.leetcode_0000_0099.leetcode0057;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lipan
 * <p>
 * 题目：
 * 57. 插入区间
 * <p>
 * 内容：
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class Solution_0057 {

    /**
     * 56 题的变种
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 边界条件
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> tmp = new ArrayList<>();
        tmp.add(newInterval);
        for (int[] interval : intervals) {
            tmp.add(interval);
        }
        tmp.sort((a, b) -> (a[0] - b[0]));
        List<int[]> result = new ArrayList<>();
        for (int[] ints : tmp) {
            if (result.size() == 0 || result.get(result.size() - 1)[1] < ints[0]) {
                result.add(ints);
            } else {
                result.get(result.size() - 1)[1] = Math.max(ints[1], result.get(result.size() - 1)[1]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
