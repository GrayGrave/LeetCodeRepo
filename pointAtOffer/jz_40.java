package pointAtOffer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数
 * 思路：Top K 问题使用堆进行解决
 */
public class jz_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        //利用大根堆进行求解
        Queue<Integer> maxHeap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            } else if (num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }
        int[] res = new int[k];
        int index = 0;
        for (int num : maxHeap) {
            res[index++] = num;
        }
        return res;
    }
}
