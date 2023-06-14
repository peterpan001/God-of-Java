/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * <p>
 * 内容：
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */
public class Solution_43 {

    public int countDigitOne(int n) {
        // 几个变量计算：cur = (n / bit) % 10，low = n % bit，high = n / bit / 10
        // 几个公式
        // cur > 1 => (high + 1) * bit
        // cur == 1 => (high * bit) + (1 + low)
        // cur = 0 => high * bit

        long bit = 1;
        int sum = 0;
        while (bit <= n) {
            long cur = (n / bit) % 10;
            long low = n % bit;
            long high = n / bit / 10;
            if (cur > 1) {
                sum += (high + 1) * bit;
            } else if (cur == 1) {
                sum += (high * bit) + (1 + low);
            } else {
                sum += high * bit;
            }
            bit = bit * 10;
        }
        return sum;
    }
}