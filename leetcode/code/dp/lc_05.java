package leetcode.code.dp;

/**
 * 最长回文子串   note：与lc_647 回文子串，同一个问题载体
 * 思路：dp  dp[i][j]代表s[i..j]是否是回文子串  从下到上，从左到右进行右上半部分的二维表填充，对角线为true是 base case
 *
 *  O(0,0)----> j
 *  |
 *  |
 *  i
 */
public class lc_05 {
    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) return "";
        int n = s.length();
        // dp[i][j]代表s[i..j]是否是回文子串
        boolean[][] dp = new boolean[n][n];

        int[] res = new int[2];
        //base case 只有一个字符的子串都是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 进行dp表的填充，从下到上，从左到右(j>i,即填充二维表的右上半部分)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) dp[i][j] = true;
                        // 剥去两端的字符，内部子串若是回文串则整体也是回文串
                    else dp[i][j] = dp[i + 1][j - 1];
                } else dp[i][j] = false;  // 两端字符不相等，肯定不是回文字符串

                // 进行最长回文子串更新
                if (dp[i][j]) {
                    if (j - i > res[1] - res[0]) {
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }
        return s.substring(res[0],res[1]+1);  // [ )

    }

}
