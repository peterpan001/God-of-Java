/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 11. 旋转数组的最小数字
 * <p>
 * 内容：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 */
public class Solution_11 {

    public int minArray(int[] numbers) {
        // 如果数据为空，直接返回-1
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        // 如果数组长度为1，直接返回即可
        if (numbers.length == 1) {
            return numbers[0];
        }
        // 获取数组的左右下标位置
        int l = 0;
        int r = numbers.length - 1;
        // 查找数据最小值
        while (l < r) {
            // 如果最左边小于最右边代表此数组一直有序，返回最左边元素即可
            if (numbers[l] < numbers[r]) {
                return numbers[l];
            }
            // 获取数组中间位置
            int mid = (l + r) / 2;
            // 如果中间位置大于左边元素，l 向右移动，否则 r 向左移动，相等则l向右移动一位，继续查找
            if (numbers[mid] > numbers[l]) {
                l = mid + 1;
            } else if (numbers[mid] < numbers[l]) {
                r = mid;
            } else {
                l++;
            }
        }
        // 此时 numbers[l] 即为最小值
        return numbers[l];
    }
}