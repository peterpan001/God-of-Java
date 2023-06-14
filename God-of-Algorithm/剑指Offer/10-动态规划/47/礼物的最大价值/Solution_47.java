/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 47. 礼物的最大价值
 * <p>
 * 内容：
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class Solution_47 {

    /**
     * 礼物的最大价值，借助O(m*n)的空间复杂度，记录出每一步到此(i, j)的最大值，遍历完整个集合，(rows-1, cols-1)
     * 即为最大值
     */
    public int maxValueMethod1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 0; j < cols; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    /**
     * 优化空间复杂度
     */
    public int maxValueMethod2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dp = new int[cols];
        dp[0] = grid[0][0];
        for (int i = 1; i < cols; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < cols; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[cols - 1];
    }
}