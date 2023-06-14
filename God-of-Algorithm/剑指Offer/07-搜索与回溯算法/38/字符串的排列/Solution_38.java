import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 38. 字符串的排列
 * <p>
 * 内容：
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
class Solution_38 {

    List<Character> path;
    List<String> res;
    boolean[] visited;

    /**
     * 借助深度遍历进行解答
     */
    public String[] permutation(String s) {
        this.path = new ArrayList<>();
        this.res = new ArrayList<>();
        this.visited = new boolean[s.length()];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        dfs(arr, 0);
        String[] resStr = new String[res.size()];
        int idx = 0;
        for (String re : res) {
            resStr[idx++] = re;
        }
        return resStr;
    }

    /**
     * 深度遍历
     */
    private void dfs(char[] arr, int k) {
        if (arr.length == k) {
            res.add(listToString(path));
            return;
        }
        // 进行 N 叉树搜索
        for (int i = 0; i < arr.length; i++) {
            // 进行剪枝操作
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                // 递归访问
                visited[i] = true;
                path.add(arr[i]);
                dfs(arr, k + 1);
                // 回溯，值复原
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }

    /**
     * list 转字符串
     */
    private String listToString(List<Character> list) {
        StringBuilder builder = new StringBuilder();
        for (Character character : list) {
            builder.append(character);
        }
        return builder.toString();
    }
}