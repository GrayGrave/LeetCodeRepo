package leetcode.code;

/**
 * 字符串相乘      lc_02两数相加、lc_XX两数相减   todo
 */
public class lc_43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] res = new int[num1.length() + num2.length()];

        // 从个位开始逐一相乘
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';

                int sum = res[i + j + 1] + n1 * n2;  // note：i,j位相乘的结果放在第i+j位i+j+1位
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;             // 易错点💡
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;     // 第一位可能为0
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
