package leetcode.code.heap;

import java.util.PriorityQueue;

/**
 * 有序矩阵中第 K 小的元素    每行每列元素均按升序进行排列
 * 思路：堆    每次弹出矩阵中的最小值，第k个被弹出的就是我们需要的数字
 */
public class lc_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();

        for (int j = 0; j < n; j++) pq.offer(new Tuple(0, j, matrix[0][j]));  // 第1列加入堆中(类似有序链表的头结点)
        for (int i = 0; i < k - 1; i++) {             // 小根堆，去掉 k - 1 个堆顶元素，此时堆顶元素就是第 k 的数 todo
            Tuple t = pq.poll();
            if (t.x == m - 1) continue;
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y])); // 加入弹出元素(当前最小值)，下方的数
        }
        return pq.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x, y, val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }

}
