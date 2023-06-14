package leetcode_0000_0299.leetcode_0000_0099.leetcode0090;

import java.util.*;

/**
 * @author lipan
 * <p>
 * 题目：
 * 90. 子集 II
 * <p>
 * 内容：
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class Solution_0090 {

    /**
     * 扩展法，又称暴力法
     */
    public List<List<Integer>> subsetsWithDupMethod1(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        // 对数组进行排序
        Arrays.sort(nums);
        // 对结果集进行去重
        Set<List<Integer>> hashSet = new HashSet<>();
        // 将空集添加进结果集
        hashSet.add(new ArrayList<>());
        // 存储所有的可能性
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        // 遍历数组，对结果集进行扩展
        for (int num : nums) {
            List<List<Integer>> subset = new ArrayList<>();
            for (List<Integer> list : result) {
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(num);
                subset.add(tmp);
            }
            for (List<Integer> list : subset) {
                result.add(list);
                hashSet.add(list);
            }
        }
        return new ArrayList<>(hashSet);
    }

    /**
     * 回溯法
     */
    public List<List<Integer>> subsetsWithDupMethod2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        // 将数组元素排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // 放入空集
        result.add(new ArrayList<>());
        // 按长度进行回溯
        for (int i = 1; i <= nums.length; i++) {
            backtracking(nums, result, i, 0, new ArrayList<>());
        }
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, int length, int begin, List<Integer> list) {
        // 如果list长度等于length，添加进result结果集中
        if (list.size() == length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 开始遍历nums
        for (int i = begin; i < nums.length; i++) {
            // 如果i大于起始位置，并且i-1元素等于i的则跳过
            if (i > begin && nums[i - 1] == nums[i]) {
                continue;
            }
            // 将 nums[i] 放入 list 中
            list.add(nums[i]);
            // 回溯
            backtracking(nums, result, length, i + 1, list);
            // 将 nums[i] 移除
            list.remove(list.size() - 1);
        }
    }

    /**
     * dfs 法
     */
    public List<List<Integer>> subsetsWithDupMethod3(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, int index, List<Integer> list) {
        result.add(new ArrayList<>(list));
        if (nums.length == index) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, result, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
