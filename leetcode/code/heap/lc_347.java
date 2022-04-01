package leetcode.code.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前 K 个高频元素
 */
public class lc_347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 记录每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 小根堆，根据元素的频次排序
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry);
            // 维护堆的大小
            if (heap.size() > k) heap.poll();  // 末尾淘汰低频元素，留下前K个高频元素
        }
        int[] res = new int[k];
        int i = 0;
        while (!heap.isEmpty()) {
            res[i++] = heap.poll().getKey();
        }
        /*for (Map.Entry<Integer, Integer> entry : heap) {
            res[i++] = entry.getKey();
        }*/
        return res;
    }
}