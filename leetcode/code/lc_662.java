package leetcode.code;

import leetcode.code.dataStruct.TreeNode;

import java.util.*;

/**
 * 二叉树最大宽度
 * 思路: BFS
 * 宽度优先搜索顺序遍历每个节点的过程中，我们记录节点的 position 信息，  note：
 * 对于每一个深度，第一个遇到的节点是最左边的节点，最后一个到达的节点是最右边的节点。
 */
public class lc_662 {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, res = 0;

        while (!queue.isEmpty()) {
            AnnotatedNode cur = queue.poll();
            if (cur.node != null) {             // 添加左右子节点
                queue.add(new AnnotatedNode(cur.node.left, cur.depth + 1, cur.pos * 2));
                queue.add(new AnnotatedNode(cur.node.right, cur.depth + 1, cur.pos * 2 + 1));

                // 遍历进入了新的一层
                if (curDepth != cur.depth) {
                    curDepth = cur.depth;
                    left = cur.pos;
                }
                // 更新最大宽度
                res = Math.max(res, cur.pos - left + 1);
            }
        }
        return res;
    }


    class AnnotatedNode {
        TreeNode node;
        int depth, pos;

        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;  // 节点所处深度
            pos = p;    // 节点位置序号
        }
    }
}

