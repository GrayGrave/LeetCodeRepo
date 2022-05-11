package leetcode.code.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 课程表  [0,1] 代表课程0的先修课程是1
 * 判断是否可以完成所有的课程学习（判断课程之间的有向图是否存在环）？即是否存在拓扑排序问题，秋招字节面试曾遇到此题
 * 思路：bfs
 */
public class lc_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度表，记录每个节点的入度数
        int[] inDegrees = new int[numCourses];
        // 邻接表(出度表)，记录每个节点往外连接的情况
        List<List<Integer>> adjacency = new ArrayList<>();
        // 进行BFS的队列
        Queue<Integer> queue = new LinkedList<>();

        // 每个节点一条list，记录连接情况的
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        // 获取每门课程的入度表和出度表
        for (int[] cp : prerequisites) {
            // 记录每门课程的入度表，即当前课程的先修课程数量，inDegrees下标即代表第几门课
            inDegrees[cp[0]]++;
            // 记录每门课程的出度表，即记录当前课程对应哪些后续课程
            adjacency.get(cp[1]).add(cp[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            // note：入度为零的课程成功出队-> 拓扑排序可以成功摘掉的节点
            if (inDegrees[i] == 0) queue.offer(i);
        }

        // BFS
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // 课程数减1
            numCourses--;
            // 该节点的后续课程的入度都减1，入度为0的节点入队，继续BFS
            for (int next : adjacency.get(cur)) {
                if (--inDegrees[next] == 0) queue.offer(next);
            }
        }
        // 所有课程成功出队，即存在拓扑排序，即不存在环
        return numCourses == 0;
    }

}
