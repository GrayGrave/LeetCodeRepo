package leetcode.code;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 思路：堆   note: 根据一个大根堆和一个小根堆巧妙地将中位数逼到中间   -> 中位数 <-
 */
public class lc_295 {
    public class MedianFinder {
        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            modifyTwoHeaps();
        }

        private void modifyTwoHeaps() {
            if (maxHeap.size() == minHeap.size() + 2) minHeap.add(maxHeap.poll());
            if (minHeap.size() == maxHeap.size() + 2) maxHeap.add(minHeap.poll());
        }

        public double findMedian() {
            // if (maxHeap.isEmpty()) return null;
            if (maxHeap.size() == minHeap.size())
                return (double) (minHeap.peek() + maxHeap.peek()) / 2;
            else return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
    }


}


