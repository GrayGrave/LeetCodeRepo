package pointAtOffer;

import java.util.ArrayList;

/**
 * 字符串的排列
 * 思路：即全排列问题，回溯
 */
public class jz_38 {
    //标准回溯问题
    ArrayList<String> res = new ArrayList<>();

    public String[] permutation(String s) {
        char[] chas = s.toCharArray();
        dfs(chas, 0);

        String[] str = new String[res.size()];
        if (s == null || s.length() == 0) return str;
        for (int i = 0; i < res.size(); i++) {
            str[i] = res.get(i);
        }
        return str;
    }

    public void dfs(char[] chas, int start) {
        // 边界条件
        if (start == chas.length) {
            res.add(new String(chas));
            return;
        }
        boolean[] used = new boolean[256];       // 进行去重
        //候选节点
        for (int i = start; i < chas.length; i++) {
            if (used[chas[i]]) continue;
            used[chas[i]] = true;

            swap(chas, start, i);    // "压入"
            dfs(chas, start + 1);
            swap(chas, start, i);    // "弹出"
        }
    }

    public void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}

