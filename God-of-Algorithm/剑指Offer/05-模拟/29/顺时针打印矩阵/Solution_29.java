/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 29. 顺时针打印矩阵
 * <p>
 * 内容：
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Solution_29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] res = new int[rows * columns];
        // 定义四个指针来管控遍历的边界与退出的条件
        int up = 0;
        int left = 0;
        int right = columns - 1;
        int down = rows - 1;
        int idx = 0;
        while (true) {
            // 遍历上面一行：从左向右
            for (int i = left; i <= right; i++) {
                res[idx++] = matrix[up][i];
            }
            if (++up > down) {
                break;
            }
            // 遍历右边一列：从上到下
            for (int i = up; i <= down; i++) {
                res[idx++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            // 遍历底部一行：从右向左
            for (int i = right; i >= left; i--) {
                res[idx++] = matrix[down][i];
            }
            if (--down < up) {
                break;
            }
            // 遍历左边一列：从下向上
            for (int i = down; i >= up; i--) {
                res[idx++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }

        return res;
    }
}