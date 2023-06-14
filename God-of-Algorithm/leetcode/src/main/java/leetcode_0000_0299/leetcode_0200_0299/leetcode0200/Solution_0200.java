package leetcode_0000_0299.leetcode_0200_0299.leetcode0200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lipan
 * <p>
 * 题目：
 * 200. 岛屿数量
 * <p>
 * 内容：
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class Solution_0200 {

    /**
     * 深度遍历 DFS
     */
    public int numIslandsMethod1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows || j <= cols || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j, rows, cols);
        dfs(grid, i, j + 1, rows, cols);
        dfs(grid, i + 1, j, rows, cols);
        dfs(grid, i, j - 1, rows, cols);
    }

    /**
     * 广度遍历 BFS，借助队列实现
     */
    public int numIslandsMethod2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    queue.add(new int[]{i, j});
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            queue.add(new int[]{x - 1, y});
                            grid[x - 1][y] = '0';
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            queue.add(new int[]{x, y - 1});
                            grid[x][y - 1] = '0';
                        }
                        if (x + 1 < rows && grid[x + 1][y] == '1') {
                            queue.add(new int[]{x + 1, y});
                            grid[x + 1][y] = '0';
                        }
                        if (y + 1 < cols && grid[x][y + 1] == '1') {
                            queue.add(new int[]{x, y + 1});
                            grid[x][y + 1] = '0';
                        }

                    }
                }
            }
        }
        return result;
    }
}
