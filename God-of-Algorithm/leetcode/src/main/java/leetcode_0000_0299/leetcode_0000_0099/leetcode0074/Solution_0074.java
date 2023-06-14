package leetcode_0000_0299.leetcode_0000_0099.leetcode0074;

/**
 * @author lipan
 * <p>
 * 题目：
 * 74. 搜索二维矩阵
 * <p>
 * 内容：
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * <p>
 * * 每行中的整数从左到右按非递减顺序排列。
 * * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true；否则，返回 false 。
 */
public class Solution_0074 {

    /**
     * 借助搜索二维矩阵规律，选取右下或者左上的点开始查询判断
     */
    public boolean searchMatrixMethod1(int[][] matrix, int target) {
        // 边界条件
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = rows - 1;
        int j = 0;
        while (i >= 0 && j < cols) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 借助搜索二维矩阵规律，借助二分查找法判断，将二维矩阵平铺，形成一维矩阵，然后找规律
     */
    public boolean searchMatrixMethod2(int[][] matrix, int target) {
        // 边界条件
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int ele = matrix[mid / cols][mid % cols];
            if (ele == target) {
                return true;
            } else if (ele > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
