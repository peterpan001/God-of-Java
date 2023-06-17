import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * <p>
 * 内容：
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Solution_59_I {

    /**
     * 借助双端队列解决问题，构造一个单调递减的双端队列，每次队列头都是最大的元素
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 边界条件判断
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        // 声明一个双端队列
        Deque<Integer> deque = new LinkedList<>();
        // 先获取前k个元素中的最大值
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        int idx = 0;
        int[] res = new int[nums.length - k + 1];
        // 将第一个窗口的最大元素放入队列中
        res[idx++] = deque.peekFirst();
        // 窗口开始滑动，直到队列末位
        for (int i = k; i < nums.length; i++) {
            // 将不在窗口的最大元素移除
            if (nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            // 将最大值放入队列中，从后向前放
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            // 队列头即为下一个窗口的最大元素
            res[idx++] = deque.peekFirst();
        }
        return res;
    }
}