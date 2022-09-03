package pointAtOffer;

import java.util.Stack;

/**
 * 包含min函数的栈
 */
public class jz_30 {
    class MinStack {
        Stack<Integer> mainStack ,minStack;
        public MinStack() {
            mainStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if (minStack.isEmpty()||x <= minStack.peek()) {
                minStack.push(x);
            }
            mainStack.push(x);
        }

        public void pop() {
            if (mainStack.peek().equals(minStack.peek())){
                minStack.pop();
            }
            mainStack.pop();
        }

        public int top() {
            return mainStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
