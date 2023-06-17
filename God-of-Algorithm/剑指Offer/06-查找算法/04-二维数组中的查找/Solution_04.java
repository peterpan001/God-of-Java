/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 04. 二维数组中的查找
 * <p>
 * 内容：
 * 在一个 n * m 的二维数组中，每一行都按照从左到右非递减的顺序排序，每一列都按照从上到下非递减的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution_04 {

    public boolean findNumberIn2DArrayMethod1(int[][] matrix, int target) {
        // 边界条件
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        // 从左下开始查找
        // 行数
        int rows = matrix.length;
        // 列数
        int cols = matrix[0].length;
        int row = rows - 1;
        int col = 0;
        while (row >= 0 && col < cols) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                // 当前位置元素小于目标元素，向右查找，列数++
                col++;
            } else {
                // 当前位置元素大于目标元素，向上查找，行数--
                row--;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArrayMethod2(int[][] matrix, int target) {
        // 边界条件
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        // 从右上开始查找
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                // 当前元素大于目标元素，向左查找，列--
                col--;
            } else {
                // 当前元素小于目标元素，向下查找，行++
                row++;
            }
        }
        return false;
    }
}