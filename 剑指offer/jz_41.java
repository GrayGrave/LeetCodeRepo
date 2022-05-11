package 剑指offer;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值
 * 思路：维持一个大根堆与小根堆，使大根堆堆顶小于小根堆堆顶，且两堆元素个数相差不超过1
 */
public class jz_41 {
    class MedianFinder {
        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>((v1, v2) -> v1 - v2);  // 默认小根堆
            maxHeap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            modifyTwoHeaps();
        }

        // 确保两堆元素个数相差不超过1
        private void modifyTwoHeaps() {
            if (maxHeap.size() == minHeap.size() + 2) minHeap.add(maxHeap.poll());
            if (minHeap.size() == maxHeap.size() + 2) maxHeap.add(minHeap.poll());
        }

        public double findMedian() {
            // if(maxHeap.isEmpty()) return null;   如果有必要，需要沟通返回何值代表空输入
            if (maxHeap.size() == minHeap.size())
                return (double) (minHeap.peek() + maxHeap.peek()) / 2;
            else return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
    }
}
