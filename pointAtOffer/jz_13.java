package pointAtOffer;

/**
 * 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * 思路：dfs
 */
public class jz_13 {
        public  int movingCount(int m, int n,int k) {
            if (m <= 0 || n <= 0 || k < 0)
                return 0;
            // 记录被访问过的方格
            boolean[][] visitFlag = new boolean[m][n];
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++)
                    visitFlag[row][col] = false;
            }
            return movingCountCore(k, m, n, 0, 0, visitFlag);
        }

        public int movingCountCore(int k, int m, int n, int row, int col, boolean[][] visitFlag) {
            int count = 0;
            if (canGetIn(k, m, n, row, col, visitFlag)) {
                visitFlag[row][col] = true;
                count = 1 + movingCountCore(k, m, n, row - 1, col, visitFlag) +
                        movingCountCore(k, m, n, row + 1, col, visitFlag) +
                        movingCountCore(k, m, n, row, col - 1, visitFlag) +
                        movingCountCore(k, m, n, row, col + 1, visitFlag);
            }
            return count;
        }

        public  boolean canGetIn(int k, int m, int n, int row, int col, boolean[][] visitFlag) {
            return row >= 0 && col >= 0 && row < m
                    && col < n && !visitFlag[row][col]
                    && getDigitSum(row) + getDigitSum(col) <= k;
        }

        public  int getDigitSum(int number) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum;
        }
    }

