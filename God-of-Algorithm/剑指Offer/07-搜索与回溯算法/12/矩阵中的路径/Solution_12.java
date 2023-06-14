/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 12. 矩阵中的路径
 * <p>
 * 内容：
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */
class Solution_12 {
    int rows;
    int cols;
    int len;
    boolean[][] visited;

    /**
     * 方法一，借助 m*n 的辅助空间来解决问题
     */
    public boolean exist1(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0){
            return false;
        }
        rows = board.length;
        cols = board[0].length;
        len  = word.length();
        visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(dfs1(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs1(char[][] board, int i, int j, String word, int k){
        if(i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] || board[i][j] != word.charAt(k)){
            return false;
        }
        if(k == len - 1){
            return true;
        }
        visited[i][j] = true;
        boolean res = dfs1(board, i + 1, j, word, k + 1) ||
                      dfs1(board, i, j + 1, word, k + 1) ||
                      dfs1(board, i - 1, j, word, k + 1) ||
                      dfs1(board, i, j - 1, word, k + 1);
        visited[i][j] = false;
        return res;
    }

    /**
     * 方法二，不借助任何辅助空间来解决问题，但是依然是要用到深度遍历搜索算法
     */
    public boolean exist2(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0){
            return false;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs2(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs2(char[][] board, int i, int j, String word, int k){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)){
            return false;
        }
        if(k == word.length() - 1){
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs2(board, i + 1, j, word, k + 1) ||
                      dfs2(board, i, j + 1, word, k + 1) ||
                      dfs2(board, i - 1, j, word, k + 1) ||
                      dfs2(board, i, j - 1, word, k + 1);
        board[i][j] = tmp;
        return res;
    }
}