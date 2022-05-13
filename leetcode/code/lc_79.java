package leetcode.code;

/**
 * 单词搜索
 * 思路：回溯算法
 */
public class lc_79 {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        // 以矩阵的每个坐标作为起点进行搜索
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, chars, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] chars, int index) {
        // 边界条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != chars[index])
            return false;
        if (index == chars.length - 1) return true;

        // note 回溯搜索过程 ,经典的回溯过程是for循环四个方向(候选节点)，此处将经典写法合并。lc_257 求二叉树的所有路径也是这种情况
        char temp = board[i][j];
        board[i][j] = '/';

        // 只要有有一个方向成功则停止，即剪枝操作
        boolean res = dfs(board, i + 1, j, chars, index + 1)
                || dfs(board, i - 1, j, chars, index + 1)
                || dfs(board, i, j + 1, chars, index + 1)
                || dfs(board, i, j - 1, chars, index + 1);
        board[i][j] = temp;
        return res;
    }

}
