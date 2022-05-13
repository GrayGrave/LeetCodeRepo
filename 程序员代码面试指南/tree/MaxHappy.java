package 程序员代码面试指南.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 求聚会的最大欢乐值，公司成员关系是一棵N叉树，X参加聚会，则其直接下级不会参加聚会
 * 思路：二叉树递归套路
 */
public class MaxHappy {

    public static int maxHappy(Employee root) {
        if (root == null) return 0;
        Info res = process(root);
        return Math.max(res.yes, res.no);
    }

    public static Info process(Employee root) {
        // base case 基层员工
        if (root.nexts.isEmpty()) {
            return new Info(root.happy, 0);
        }

        // 搜集子树的信息
        int yes = root.happy;
        int no = 0;
        for (Employee e : root.nexts) {
            Info nextInfo = process(e);
            yes += nextInfo.no;                         // root节点参加，直接下属nexts不参加
            no += Math.max(nextInfo.yes, nextInfo.no);  // root节点不参加，直接下属可以参加，可以不参加
        }

        // 整理信息并返回 （整理部分在for循环中完成）
        return new Info(yes, no);
    }


    public static class Info {
        int yes;    // 该节点来参加聚会的最大快乐值
        int no;     // 该节点不来参见聚会的最大快乐值

        public Info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }


    public static class Employee {
        int happy;
        List<Employee> nexts;

        public Employee(int happy) {
            this.happy = happy;
            this.nexts = new ArrayList<>();
        }
    }
}
