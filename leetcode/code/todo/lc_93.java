package leetcode.code.todo;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 * "25525511135" -> ["255.255.11.135","255.255.111.35"]
 * 思路：回溯算法
 * todo 逻辑还没吃透
 */
public class lc_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder chain = new StringBuilder();
        dfs(s, 0, chain, res);
        return res;
    }

    private void dfs(String s, int index, StringBuilder chain, List<String> res) {
        // base case
        if (index == 4 || s.length() == 0) {
            if (index == 4 && s.length() == 0) {
                res.add(chain.toString());
            }
            return;
        }

        // 候选节点：当前指针与之后的两个位置
        for (int i = 0; i < s.length() && i < 3; i++) {
            // 每个整数位于0到255之间，且不能含有前导0
            if (i != 0 && s.charAt(i) == '0') break;

            String part = s.substring(0, i + 1);   // [ )
            if (Integer.parseInt(part) <= 255) {
                if (chain.length() != 0) {
                    part = "." + part;
                }

                // 压入
                chain.append(part);
                // s.substring(i + 1) 截取当前指针之后的片段
                dfs(s.substring(i + 1), index + 1, chain, res);
                // 弹出
                chain.delete(chain.length() - part.length(), chain.length()); // [ )
            }
        }


    }
}
