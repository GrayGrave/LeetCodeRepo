package leetcode.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 课程表II  返回任意一种课程完成顺序
 * 思路：bfs
 */
public class lc_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] inDegrees = new int[numCourses];              // 入度表
        List<List<Integer>> adjacency = new ArrayList<>();  // 邻接表(出度表)
        Queue<Integer> queue = new LinkedList<>();          // 进行BFS的队列

        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] cp : prerequisites) {
            inDegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }

        int index = 0;
        // BFS
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // 顺序记录
            res[index++] = cur;
            numCourses--;

            // 该节点的后续课程的入度都减1，入度为0的节点入队，继续BFS
            for (int next : adjacency.get(cur)) {
                if (--inDegrees[next] == 0) queue.offer(next);
            }
        }
        if (numCourses == 0) return res;
        else return new int[0];
    }
}
