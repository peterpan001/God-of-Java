package leetcode_0000_0299.leetcode_0000_0099.leetcode0078;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lipan
 * <p>
 * 题目：
 * 78. 子集
 * <p>
 * 内容：
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Solution_0078 {

    /**
     * 扩展法
     */
    public List<List<Integer>> subsetsMethod1(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 添加空集
        result.add(new ArrayList<>());
        // 遍历 nums
        for (int num : nums) {
            // 声明子集
            List<List<Integer>> subset = new ArrayList<>();
            // 遍历result结果集，将result元素取出来并进行复制，然后将每个元素都添加当前元素 num
            for (List<Integer> list : result) {
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(num);
                subset.add(tmp);
            }
            // 将当前子集结果放入 result 结果集中
            for (List<Integer> list : subset) {
                result.add(list);
            }
        }
        return result;
    }

    /**
     * 回溯法
     */
    public List<List<Integer>> subsetsMethod2(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        // 存放结果集
        List<List<Integer>> result = new ArrayList<>();
        // 添加空集
        result.add(new ArrayList<>());
        // 定义长度，从1到数组长度
        for (int i = 1; i <= nums.length; i++) {
            backtracking(nums, result, i, 0, new ArrayList<>());
        }
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, int length, int begin, List<Integer> subset) {
        // 如果子集大小等于length，将子集放入结果集中
        if (subset.size() == length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // 开始遍历nums
        for (int i = begin; i < nums.length; i++) {
            // 将元素放入
            subset.add(nums[i]);
            // 回溯
            backtracking(nums, result, length, i + 1, subset);
            // 将元素移除
            subset.remove(subset.size() - 1);
        }
    }

    /**
     * 深度遍历
     */
    public List<List<Integer>> subsetsMethod3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, int index, List<Integer> subset) {
        result.add(new ArrayList<>(subset));
        if (nums.length == index) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, result, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
