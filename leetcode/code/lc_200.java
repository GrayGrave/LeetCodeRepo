package leetcode.code;

/**
 * 岛屿数量
 * 思路：dfs/bfs
 * note： dfs 进行深度优先搜索(病毒感染)，访问过的地方进行标记，不再进行重复访问。和回溯的区别：回溯涉及到不轨迹问题(lc_79 单词搜索)，
 *  则访问过后需要进行现场恢复！！而对于只是要进行遍历搜索而言，则无需进行现场恢复！
 *  即是否恢复现场要看是否涉及不同轨迹的提取！！(十分重要！)
 */
public class lc_200 {
    public int numIslands(char[][] p) {
        if (p.length == 0 || p[0].length == 0) return 0;
        int res = 0;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[0].length; j++) {
                // 寻找可以进入进行dfs的入口，只要可以进行则必有一个岛屿
                if (p[i][j] == '1') {
                    // 进行"感染"
                    dfs(p, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] p, int i, int j) {
        // 截止条件
        if (i < 0 || i >= p.length || j < 0 || j >= p[0].length || p[i][j] != '1')
            return;
        // 标记访问
        p[i][j] = '*';
        // 候选节点：相邻四个点进行"感染"
        dfs(p, i - 1, j);
        dfs(p, i + 1, j);
        dfs(p, i, j - 1);
        dfs(p, i, j + 1);
    }
}
