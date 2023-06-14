package leetcode_0000_0299.leetcode_0000_0099.leetcode0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lipan
 * <p>
 * 题目：
 * 56. 合并区间
 * <p>
 * 内容：
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class Solution_0056 {

    public int[][] merge(int[][] intervals) {
        // 边界条件
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        // 按数组首元素进行排序
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            // 如果result为空或者 result 末位数组的最后一个元素，小于当前interval数组的第一个元素，则直接添加，否则修改result的最后一个元素
            if (result.size() == 0 || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }
        // 转化为二维数组返回
        return result.toArray(new int[result.size()][2]);
    }
}
