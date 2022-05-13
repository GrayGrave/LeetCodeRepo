package leetcode.code;

/**
 * 岛屿最大面积
 * 思路：dfs/bfs
 * 和lc200岛屿数量的区别：进行搜索时关注面积，最后返回最大岛屿面积
 */
public class lc_695 {
    int maxArea = 0;

    public int maxAreaOfIsland(int[][] p) {
        if (p.length == 0 || p[0].length == 0) return 0;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[0].length; j++) {
                // 寻找可以进入进行dfs的入口，只要可以进行则必有一个岛屿
                if (p[i][j] == 1) {
                    // 对每个岛屿进行搜索时，记录岛屿的面积，然后更新岛屿最大面积
                    int[] area = new int[1];
                    // 进行"感染"
                    dfs(p, i, j, area);
                    // 更新岛屿最大面积
                    maxArea = Math.max(maxArea, area[0]);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] p, int i, int j, int[] area) {
        // 截止条件
        if (i < 0 || i >= p.length || j < 0 || j >= p[0].length || p[i][j] != 1)
            return;
        // 标记访问
        p[i][j] = 2;
        // 岛屿面积加1
        area[0]++;
        // 候选节点：相邻四个点进行"感染"
        dfs(p, i - 1, j, area);
        dfs(p, i + 1, j, area);
        dfs(p, i, j - 1, area);
        dfs(p, i, j + 1, area);
    }
}
