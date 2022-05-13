package leetcode.code;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 滑动窗口最大值
 * 思路：堆、双端队列
 */
public class lc_239 {
    // 解法一:双端队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (i - queue.peekFirst() == k) {
                queue.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    // 解法二：堆
    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        res[idx++] = heap.peek();
        for (int i = k; i < nums.length; i++) {
            heap.remove(nums[i - k]);
            heap.offer(nums[i]);
            res[idx++] = heap.peek();
        }
        return res;
    }
}
