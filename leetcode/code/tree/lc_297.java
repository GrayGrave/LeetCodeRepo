package leetcode.code.tree;

import leetcode.dataStruct.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树的序列化与反序列化
 * note 锻炼codeing与数据结构理解的好题！
 * 思路：
 * 1) 序列化即将二叉树打平成一维(null使用特殊字符占位)，即使用树的遍历（前序、中序、后序、层级遍历）
 * 2) 反序列化则将一维数组建立成一棵树，因为有占位符，所以只需要一个序列即可重建出二叉树
 */
public class lc_297 {

    // 利用前序遍历方法
    String SEP = ",";
    String NULL = "#";

    // 主函数，将二叉树序列化为字符串
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // 辅助函数，将二叉树存入 StringBuilder
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        // 前序方式遍历
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // 主函数，将字符串反序列化为二叉树结构
    public TreeNode deserialize(String data) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    // 辅助函数，通过 nodes 列表构造二叉树
    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        // 前序方式遍历，列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;  // 遇到null则该分支结束，返回null即可
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(nodes);  // 建左边分支
        root.right = deserialize(nodes); // 建右边分支

        return root;
    }
}
