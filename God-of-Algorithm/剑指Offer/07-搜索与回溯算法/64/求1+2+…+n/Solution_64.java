/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 64. 求1+2+…+n
 * <p>
 * 内容：
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Solution_64 {

    int sum = 0;

    /**
     * 借助递归的思想解决
     */
    public int sumNumsMethod1(int n) {
        boolean flag = n > 1 && sumNumsMethod1(n - 1) < 1;
        sum += n;
        return sum;
    }


    /**
     * 借助递归的思想解决
     */
    public int sumNumsMethod2(int n) {
        boolean flag = n > 1 && (n += sumNumsMethod2(n - 1)) > 0;
        return n;
    }

}