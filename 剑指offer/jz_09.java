package 剑指offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *思路：负负得正，两次栈即可实现先进先出的顺序
 */
public class jz_09 {
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();
    // 入队
    public void appendTail(int value) {
        stackA.push(value);
    }
    // 出队
    public int deleteHead() {
        if (stackB.isEmpty()) {
            if (stackA.isEmpty()) {
                return -1;
            }
            transfer();
        }
        return stackB.pop();

    }

    public void transfer() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
    }
}
