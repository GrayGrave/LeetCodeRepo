package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value需要返回 -1
 *
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出:[null,null,null,2,1,2]
 *
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出:[null,-1,-1]
 *
 */
public class jz_59_II {

    class MaxQueue {
        Deque<Integer> res, max;  // todo
        public MaxQueue() {
            res = new LinkedList<Integer>();
            max = new LinkedList<Integer>();   // 辅助队列
        }

        public int max_value() {
            if (max.isEmpty()) return -1;
            return max.peekFirst();
        }

        public void push_back(int value) {
            res.addLast(value);
            while (!max.isEmpty() && max.peekLast() < value) max.removeLast();
            max.addLast(value);
        }

        public int pop_front() {
            if (res.isEmpty()) return -1;
            int temp = res.peekFirst();
            if (temp == max.peekFirst()) max.removeFirst();
            res.removeFirst();
            return temp;
        }
    }
}
