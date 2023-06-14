/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 44. 数字序列中某一位的数字
 * <p>
 * 内容：
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，
 * 第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 */
public class Solution_44 {

    public int findNthDigit(int n) {
        if (n == 0) {
            return 0;
        }
        long bit = 1;
        int i = 1;
        long count = 9;
        while (count < n) {
            n = (int) (n - count);
            bit = bit * 10;
            i++;
            count = bit * i * 9;
        }
        // 公式
        long num = bit + (n - 1) / i;
        int idx = (n - 1) % i + 1;
        int res = (int) (num / Math.pow(10, i - idx)) % 10;
        return res;
    }
}