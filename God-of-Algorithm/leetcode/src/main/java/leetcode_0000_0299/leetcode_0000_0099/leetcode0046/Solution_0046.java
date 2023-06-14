package leetcode_0000_0299.leetcode_0000_0099.leetcode0046;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lipan
 * <p>
 * 题目：
 * 46. 全排列
 * <p>
 * 内容：
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Solution_0046 {

    /**
     * 回溯法
     */
    public List<List<Integer>> permute(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        // 存放结果集
        List<List<Integer>> result = new ArrayList<>();
        // 记录遍历完的数字
        Map<Integer, Boolean> visited = new HashMap<>();
        // 开始都为false
        for (int num : nums) {
            visited.put(num, false);
        }
        // 回溯法
        backtracking(nums, result, visited, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, Map<Integer, Boolean> visited, ArrayList<Integer> list) {
        // 如果list大小等于数组长度，代表遍历完成
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 开始遍历
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 只处理没有遍历的数字
            if (!visited.get(num)) {
                // 将数字放入list，并将其记录为true
                list.add(num);
                visited.put(num, true);
                // 继续下一轮
                backtracking(nums, result, visited, list);
                // 回溯，将元素移除，位置标为false
                list.remove(list.size() - 1);
                visited.put(num, false);
            }
        }
    }
}
