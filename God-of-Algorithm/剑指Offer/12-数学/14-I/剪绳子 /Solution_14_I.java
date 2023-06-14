/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 14- I. 剪绳子
 * <p>
 * 内容：
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
class Solution_14_I {

    public int cuttingRopeMethod1(int n) {
        // 非法，返回 -1
        if(n <= 1){
            return -1;
        }
        // 长度为 2 时，返回 1：1 * 1
        if(n == 2){
            return 1;
        }
        // 长度为 3 时，返回 2：2 * 1；
        if(n == 3){
            return 2;
        }
        // 长度为 4 时，返回 4：2 * 2 最大；
        if(n == 4){
            return 4;
        }
        // 长度为5及以上时，尽量将其划分为更多个3的等份，这样乘积会更大
        int res = 1;
        while(n > 4){
            res = res * 3;
            n = n - 3;
        }
        return res * n;
    }

    public int cuttingRopeMethod2(int n) {
        // 非法，返回 -1
        if(n <= 1){
            return -1;
        }
        // 长度为 2 时，返回 1：1 * 1
        // 长度为 3 时，返回 2：2 * 1；
        if(n <= 3){
            return n - 1;
        }
        // 长度为 4 时，返回 4：2 * 2 最大；
        // 长度为5及以上时，尽量将其划分为更多个3的等份，这样乘积会更大
        int res = 1;
        while(n > 4){
            res = res * 3;
            n = n - 3;
        }
        return res * n;
    }
}