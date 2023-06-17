import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 59 - II. 队列的最大值
 * <p>
 * 内容：
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front
 * 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */
public class MaxQueue {

    Queue<Integer> queue; // 此队列正常存储元素
    Deque<Integer> maxQueue; // 此队列维护一个单调递减的双端队列

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int poll = queue.poll();
        if (maxQueue.peekFirst() == poll) {
            maxQueue.pollFirst();
        }
        return poll;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */