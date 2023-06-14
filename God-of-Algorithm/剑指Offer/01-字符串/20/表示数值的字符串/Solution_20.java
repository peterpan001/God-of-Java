/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 20. 表示数值的字符串
 * <p>
 * 内容：
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 */
public class Solution_20 {

    /**
     * 数值的字符串：数字、小数点、e | E, - | +
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0 || s.trim().length() < 1) { // 边界条件：字符串为空
            return false;
        }
        char[] res = s.trim().toCharArray();
        boolean isDot = false;
        boolean isE = false;
        boolean isNum = false;
        for (int i = 0; i < res.length; i++) {
            if (res[i] >= '0' && res[i] <= '9') { // 数字
                isNum = true;
            } else if (res[i] == '.') { // 小数点
                if (isDot || isE) { // 不能有重复的小数点、不能出现 e 或者 E
                    return false;
                }
                isDot = true;
            } else if (res[i] == 'e' || res[i] == 'E') { // e | E
                if (isE || !isNum) { // 不能有重复的 e、前面必须要有数字、后面也必须要有数字
                    return false;
                }
                isE = true;
                isNum = false;
            } else if (res[i] == '-' || res[i] == '+') { // - | +
                // 如果 +- 符号不在第一位且前面有e或者E 都为不合法
                if (i != 0 && res[i - 1] == 'e' && res[i - 1] == 'E') {
                    return false;
                }
            } else { // 其他字符串
                return false;
            }
        }
        return isNum;
    }
}