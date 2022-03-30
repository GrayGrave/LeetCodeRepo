package algorithmBase.tree;

public class RecursiveTraversalBT {

    /**
     * 递归的本质，每个节点会有三次机会进入，选择不同时机打印即为不同的遍历方式！
     * 对于一个节点而言，可以收集左子树的信息，再收集右子树的信息，然后统一整理信息！！ 【树相关题目核心解题思路】
     */
    public void f(TreeNode head) {
        if (head == null) return;
        // 1    第一次进入
        f(head.left);
        // 2    第二次进入
        f(head.right);
        // 3    第三次进入
    }


    // 前序
    public void pre(TreeNode head) {
        if (head == null) return;
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    // 中序
    public void in(TreeNode head) {
        if (head == null) return;
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    // 后序
    public void pos(TreeNode head) {
        if (head == null) return;
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }
}
