package leetcode.code.dp;

import leetcode.dataStruct.TreeNode;

import java.util.HashMap;
import java.util.Map;


/**
 * 打家劫舍III   房屋的排列形式是一棵二叉树
 * 思路：抢或者不抢，递归进行，相当于暴力递归-> 备忘录优化-> 还没有dp递推关系(从结果反推上一步)出现(I 和 II 总结出了递推关系而已)
 */
public class lc_337 {
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        // 利用记忆表消除重叠子问题
        if (memo.containsKey(root))
            return memo.get(root);
        // 抢，然后去下下家
        int rob = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        // 不抢，然后去下一家
        int not_rob = rob(root.left) + rob(root.right);

        // 以该节点为root的树，可以抢得的最大财产值(递归，自顶向下)💡
        int res = Math.max(rob, not_rob);
        // 结果存入记忆表
        memo.put(root, res);       // note 记忆表为何不像回溯那样随着递归往下传？因为回溯需要在递归底部搜集结果，而此处不需要！
        return res;
    }


    /** =========================================== 分割线 =====================================*/
    /**
     * 树的后序遍历-->搜集下层传递上来的信息，本层整理再往上层传
     * 即二叉树的递归套路
     */

    public int rob2(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        // base case
        if (node == null) {
            return new int[]{0, 0};
        }

        // 分类讨论的标准是：当前结点偷或者不偷
        //1、搜集下层左右节点的信息
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // dp[0]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点不偷
        // dp[1]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点偷
        //2、本层整理信息
        int[] dp = new int[2];
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = node.val + left[0] + right[0];

        //3、向上层传递信息
        return dp;
    }
}
