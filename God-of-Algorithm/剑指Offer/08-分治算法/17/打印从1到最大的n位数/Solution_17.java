/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 17. 打印从1到最大的n位数
 * <p>
 * 内容：
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
class Solution_17 {

    /**
     * 求出数组长度，然后遍历即可。此题还有一种全排列大数的解法
     */
    public int[] printNumbers(int n) {
        int cnt = (int)Math.pow(10, n);
        int[] res = new int[cnt - 1];
        for(int i = 1; i <= res.length; i++){
            res[i - 1] = i;
        }
        return res;
    }
}