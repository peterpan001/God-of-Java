package leetcode_0600_0999.leetcode_0800_0899.leetcode0881;

import java.util.Arrays;

/**
 * @author lipan
 * <p>
 * 题目：
 * 881. 救生艇
 * <p>
 * 内容：
 * 给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * <p>
 * 返回 承载所有人所需的最小船数 。
 */
public class Solution_0881 {

    /**
     * 借助左右指针解决
     */
    public int numRescueBoats(int[] people, int limit) {
        // 边界条件
        if (people == null || people.length == 0) {
            return 0;
        }
        Arrays.sort(people);
        // 定义左右指针
        int i = 0;
        int j = people.length - 1;
        int cnt = 0;
        while (i <= j) {
            // 如果左指针元素和右指针元素相加小于limit则cnt++,i++,j--【过两人】，否则cnt++，j--【过一人】
            if (people[i] + people[j] <= limit) {
                i++;
            }
            cnt++;
            j--;
        }
        return cnt;
    }
}
