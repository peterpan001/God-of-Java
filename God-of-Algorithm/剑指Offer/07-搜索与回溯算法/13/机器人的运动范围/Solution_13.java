/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 13. 机器人的运动范围
 * <p>
 * 内容：
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 */
class Solution_13 {
    /**
     * 借助深度优先遍历进行解答，因为从[0,0]开始移动，故只需要向下或者向右移动即可。可以不进行向上和向左操作。
     */
    public int movingCountMethod1(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs1(0, 0, m, n, k, visited);
    }

    private int dfs1(int i, int j, int m, int n, int k, boolean[][] visited){
        if(i >= m || j >= n || visited[i][j] || sum(i) + sum(j) > k){
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs1(i + 1, j, m, n, k, visited) + dfs1(i, j + 1, m, n, k, visited);
    }

    private int sum(int i){
        int sum = 0;
        while(i != 0){
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }
}