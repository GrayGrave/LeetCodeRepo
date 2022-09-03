package codingInterviewGuide;

import java.util.PriorityQueue;

/**
 * 数组已经基本有序(即排序时数字移动的距离不会超过K),进行从小到大排序
 * [i...t]   i到t的调整距离不会超过K,i到i+1的距离为1。
 * 思路: 利用堆
 * 比如K=5，[0,1,2,3,4,5,6..],放在0 位置的数只能是[0,..,5],则建立一个size为6(k+1)的小根堆，取出堆顶放在0 位置，
 * 6位置放入堆进行调整，再取出堆顶放在1 位置，以此类推
 * 时间复杂度：O(NlogK)
 */
public class SortArrayDistanceLessK {
    public void sortArrayDistanceLessK(int[] arr, int k) {
        //默认小根堆，构造器参入比较器可以按照自己的需求进行排序
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int index = 0;  // 0...k
        for (; index <= Math.min(arr.length-1, k); index++) {
            heap.add(arr[index]);
        }

        int i = 0;
        for (; index < arr.length-1; index++, i++) {
            arr[i] = heap.poll();    // 弹出
            heap.add(arr[index]);    // 继续放入堆中，有点类似滑动窗口的感觉
        }
        // 处理最后放在堆中的数字
        while (!heap.isEmpty()){
            arr[i++]=heap.poll();
        }

    }
}
