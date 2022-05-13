package leetcode.code;

import java.util.PriorityQueue;

/**
 * 数组中的第 K 个最大元素  ,即数组排序后的第 K 个最大的元素
 * 思路：堆
 */
public class lc_215 {
    public int findKthLargest(int[] nums, int k) {
        // 小根堆 (系统默认小根堆,不传入比较器也可以)
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            heap.offer(num);
            // 末位淘汰值最小的，即最后留下的是最强的k个值，即堆顶为这k个最大值中的最小值，第k个最大元素
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}
