package leetcode.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0 1 矩阵    todo
 * 给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1
 * 思路：bfs   note 多源【最短】路径问题   涉及最短路径的搜索问题使用bfs(水中的涟漪，一层一层往外扩散)
 */
public class lc_542 {
    // 多源最短路径问题 bfs
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        // 四个搜索方向
        int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 将源点0入队，然后从各个0同时开始一圈一圈向1扩散，每个1都是被离它最近的0扩散到的
                if (mat[i][j] == 0) queue.add(new int[]{i, j});
                    // 将数组中1的位值标记成没有被访问过
                else mat[i][j] = -1;
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            // 搜索四个方向
            for (int[] v : vector) {
                int r = cur[0] + v[0], c = cur[1] + v[1];
                // 移动一步没有超出边界，并且该位置没有被访问过
                if (r >= 0 && r < row && c >= 0 && c < col && mat[r][c] == -1) {
                    // 0扩散到了1，即1找到了离它最近的0
                    mat[r][c] = mat[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{r, c});
                }
            }
        }
        return mat;
    }
}
