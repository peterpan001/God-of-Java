/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 65. 不用加减乘除做加法
 * <p>
 * 内容：
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class Solution_65 {

    public int add(int a, int b) {
        // 如果a和b中有一个为0，直接返回
        if (a == 0 || b == 0) {
            return a == 0 ? b : a;
        }
        int tmpSum = 0, carrySum = 0;
        while (b != 0) {
            // 记录当前位
            tmpSum = a ^ b;
            // 记录前进位
            carrySum = (a & b) << 1;
            a = tmpSum;
            b = carrySum;
        }
        return a;
    }
}