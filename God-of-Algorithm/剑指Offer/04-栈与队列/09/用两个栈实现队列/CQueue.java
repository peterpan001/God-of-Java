import java.util.Stack;

/**
 * @author lipan
 * <p>
 * 题目：
 * 剑指 Offer 09. 用两个栈实现队列
 * <p>
 * 内容：
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 */
public class CQueue {

    // 声明两个栈，其中stack1栈负责进元素，stack2栈负责出元素
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    // 初始化
    public CQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    // 元素进栈
    public void appendTail(int value) {
        stack1.add(value);
    }

    // 元素出栈
    public int deleteHead() {
        // stack2 不为空，则直接出栈
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        // 否则stack1不为空，将元素放入stack2，stack2 元素出栈
        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        // 都为空，返回 -1
        return -1;
    }

}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */