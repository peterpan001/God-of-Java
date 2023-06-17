/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 67. 把字符串转换成整数
 * <p>
 * 内容：
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 */
public class Solution_67 {

    public int strToInt(String str) {
        if (str == null || str.length() == 0) { // 边界条件
            return 0;
        }
        int idx = 0;
        int res = 0;
        int maxNum = Integer.MAX_VALUE / 10; // 用于32位临界整数判断
        while (str.charAt(idx) == ' ') { // 移除掉开头的空哥
            idx++;
            if (idx == str.length()) {
                return 0;
            }
        }
        int sign = 1;
        if (str.charAt(idx) == '-') { // 如果遇到-1，声明标识符位-1，默认位1
            sign = -1;
        }
        if (str.charAt(idx) == '-' || str.charAt(idx) == '+') {
            idx++;
        }
        for (int i = idx; i < str.length(); i++) { // 循环逻辑判断
            if (str.charAt(i) > '9' || str.charAt(i) < '0') { // 如果遇到非数字字符直接跳出
                break;
            }
            if (res > maxNum || (res == maxNum && str.charAt(i) > '7')) { // 用于临界判断
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + (str.charAt(i) - '0'); // 计算
        }
        return sign * res;
    }
}