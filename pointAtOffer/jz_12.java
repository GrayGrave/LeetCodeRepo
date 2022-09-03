package pointAtOffer;

/**
 * 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 思路：dfs(涉及轨迹，回溯)
 */
public class jz_12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        // 从矩阵不同的点出发进行搜索
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != words[k]) return false;
        if (k == words.length - 1) return true;

        char temp = board[i][j];
        board[i][j] = '/';          // "压入"
        // 四个方向，即为四个候选节点
        boolean res = dfs(board, words, i, j - 1, k + 1) || dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i - 1, j, k + 1) || dfs(board, words, i + 1, j, k + 1);
        board[i][j] = temp;         // "弹出"
        return res;
    }
}

