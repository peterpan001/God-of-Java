package leetcode_0600_0999.leetcode_0700_0799.leetcode0705;

/**
 * @author lipan
 * <p>
 * 题目：
 * 705. 设计哈希集合
 * <p>
 * 内容：
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * 实现 MyHashSet 类：
 * <p>
 * * void add(key) 向哈希集合中插入值 key 。
 * * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 */
public class MyHashSet {

    boolean[] flag;

    public MyHashSet() {
        flag = new boolean[1000001];
    }

    public void add(int key) {
        flag[key] = true;
    }

    public void remove(int key) {
        flag[key] = false;
    }

    public boolean contains(int key) {
        return flag[key];
    }
}
