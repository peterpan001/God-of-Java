/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 15. 二进制中1的个数
 * <p>
 * 内容：
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数
 *（也被称为 汉明重量).）。
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，
 * 并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的示例 3 中，输入表示有符号整数 -3。
 */
public class Solution_15 {
    // you need to treat n as an unsigned value
    public int hammingWeightMethod1(int n) {
        int count = 0;
        while(n != 0){
            // n 每次与 n-1 进行与，只会消掉最低位的 1，并将其消掉末位1的数再次赋值给n后继续，直到n为0
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public int hammingWeightMethod2(int n) {
        int count = 0;
        while(n != 0){
            // 若 n & 1 = 1,则统计数 count 加一，注意位运算符优先级低于加减乘除符号
            // count = count + (n & 1)
            count += n & 1;
            // 将二进制数字 n 无符号右移一位
            n = n >>>= 1;
        }
        return count;
    }
}