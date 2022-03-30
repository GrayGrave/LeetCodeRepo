package leetcode.code;

import algorithmBase.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * 思路：回溯算法
 */
public class lc_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;

        dfs(root, new ArrayList<String>(), res);
        return res;
    }

    private void dfs(TreeNode root, ArrayList<String> chain, List<String> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            chain.add(root.value + "");
            res.add(String.join("->", chain));
            chain.remove(chain.size() - 1);
            return;
        }
        /**
         * 回溯算法，左右两边为候选节点，以下两步可以合并为下面的方式（💡）
         * chain.add(root.value + "");
         * dfs(root.left, chain, res);
         * chain.remove(chain.size()-1);
         *
         * chain.add(root.value + "");
         * dfs(root.right, chain, res);
         * chain.remove(chain.size()-1);
         */
        chain.add(root.value + "");
        dfs(root.left, chain, res);
        dfs(root.right, chain, res);
        chain.remove(chain.size() - 1);
    }

  /**  ============================== 分割线 ==================================== */

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;

        dfs2(root, "", res);
        return res;
    }

    private void dfs2(TreeNode root, String chain, List<String> res) {
        if (root == null) return;
        chain += root.value;

        if (root.left == null && root.right == null) {
            res.add(chain);
        } else {
            // 解决用StringBuilder显示压入弹出的问题,因为String 拼接会产生新的字符串
            dfs2(root.left, chain + "->", res);
            dfs2(root.right, chain + "->", res);
        }

    }
}
