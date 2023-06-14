import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 41. 数据流中的中位数
 * <p>
 * 内容：
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class MedianFinder {

    Queue<Integer> min; // 小根堆，存放大的元素
    Queue<Integer> max; // 大根堆，存放小的元素，存放元素时，优先存放到大根堆里

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        min = new PriorityQueue<>((x, y) -> (x - y));
        max = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        // 如果是偶数
        if (min.size() == max.size()) {
            min.add(num);
            max.add(min.poll());
        } else {
            max.add(num);
            min.add(max.poll());
        }
    }

    public double findMedian() {
        // 如果是偶数
        if (min.size() == max.size()) {
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return max.peek() * 1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */