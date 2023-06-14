package leetcode_0000_0299.leetcode_0000_0099.leetcode0077;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lipan
 * <p>
 * 题目：
 * 77. 组合
 * <p>
 * 内容：
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class Solution_0077 {

    /**
     * 借助回溯法解决
     */
    public List<List<Integer>> combine(int n, int k) {
        // 声明存储结果的list
        List<List<Integer>> result = new ArrayList<>();
        // 回溯方法
        backtracking(n, k, result, 1, new ArrayList<>());
        return result;
    }

    private void backtracking(int n, int k, List<List<Integer>> result, int begin, ArrayList<Integer> list) {
        // 如果 list大小等于k则将 list 添加进result中
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 遍历
        for (int i = begin; i <= n; i++) {
            // 将i添加进list中
            list.add(i);
            // 回溯
            backtracking(n, k, result, i + 1, list);
            // 将list最后一个元素移除，也就是上面的 i
            list.remove(list.size() - 1);
        }
    }
}
