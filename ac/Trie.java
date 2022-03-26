package ac;

import java.util.HashMap;

/**
 * 前缀树/字典树
 * 用途: 搜索引擎的输入联想
 * 思路：int pass：经过的次数、int end：在此结尾的次数  建树=> 从根节点出发，有就复用，无就新建
 */
public class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        if (word == null) return;
        char[] str = word.toCharArray();
        Node node = root;
        node.pass++;

        int index = 0;
        for (int i = 0; i < str.length; i++) {  // 遍历字符串
            index = str[i] - 'a';                   // 根据字符确定走哪条路
            if (node.nexts[index] == null) {        // 没有则新建
                node.nexts[index] = new Node();
            }
            node = node.nexts[index];              // 有则直接复用
            node.pass++;
        }
        node.end++;  // 标记结束，在此结尾的次数加1
    }

    // 查找单词出现的次数
    public int search(String word) {
        if (word == null) return 0;
        char[] str = word.toCharArray();
        Node node = root;
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            index = str[i] - 'a';
            // 未曾到达过此处，则没有加入过该单词
            if (node.nexts[index] == null) return 0;
            node = node.nexts[index];
        }
        return node.end;
    }

    // 所有加入的单词中，以pre字符串作为前缀的数量
    public int prefixNumber(String pre) {
        if (pre == null) return 0;
        char[] str = pre.toCharArray();
        Node node = root;
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            index = str[i] - 'a';
            // 未曾到达过此处，则没有加入过该单词
            if (node.nexts[index] == null) return 0;
            node = node.nexts[index];
        }
        return node.pass;
    }

    // 删除 world
    public void delete(String word) {
        if (search(word) != 0) {
            char[] str = word.toCharArray();
            Node node = root;
            node.pass--;

            int index = 0;
            for (int i = 0; i < str.length; i++) {
                index = str[i] - 'a';
                // 删除过后pass为零，则直接断掉后面的节点(若前缀树的结构类似链表，则提前断掉会加快速度)
                if (--node.nexts[index].pass == 0) {
                    node.nexts[index] = null;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

    /**
     * ============================== 分割线 =================================
     */
    public static class Trie2 {
        private Node2 root;

        public Trie2() {
            root = new Node2();
        }

        public void insert(String word) {
            if (word == null) return;

            char[] str = word.toCharArray();
            Node2 node = root;
            node.pass++;

            int index = 0;
            for (int i = 0; i < str.length; i++) {      // 遍历字符串
                index = (int) str[i];                   // 根据字符确定走哪条路
                if (!node.nexts.containsKey(index)) {    // 没有则新建
                    node.nexts.put(index, new Node2());
                }
                node = node.nexts.get(index);            // 有则直接复用
                node.pass++;
            }
            node.end++;  // 标记结束，在此结尾的次数加1
        }

        // 查找单词出现的次数
        public int search(String word) {
            if (word == null) return 0;

            char[] str = word.toCharArray();
            Node2 node = root;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                index = (int) str[i];
                // 未曾到达过此处，则没有加入过该单词
                if (!node.nexts.containsKey(index)) return 0;
                node = node.nexts.get(index);
            }
            return node.end;
        }

        // 所有加入的单词中，以pre字符串作为前缀的数量
        public int prefixNumber(String pre) {
            if (pre == null) return 0;

            char[] str = pre.toCharArray();
            Node2 node = root;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                index = (int) str[i];
                // 未曾到达过此处，则没有加入过该单词
                if (!node.nexts.containsKey(index)) return 0;
                node = node.nexts.get(index);
            }
            return node.pass;
        }

        // 删除 world
        public void delete(String word) {
            if (search(word) != 0) {
                char[] str = word.toCharArray();
                Node2 node = root;
                node.pass--;

                int index = 0;
                for (int i = 0; i < str.length; i++) {
                    index = (int) str[i];
                    // 删除过后pass为零，则直接断掉后面的节点(若前缀树的结构类似链表，则提前断掉会加快速度)
                    if (--node.nexts.get(index).pass == 0) {
                        node.nexts.put(index, null);
                    }
                    node = node.nexts.get(index);
                }
                node.end--;
            }
        }
    }


    public static class Node {
        public int pass;
        public int end;
        public Node[] nexts;

        public Node() {
            pass = 0;
            end = 0;
            /**
             * 0    a
             * 1    b
             * ...
             * 25   z
             * next[i]==null    i方向的路不存在
             * next[i]!=null    i方向的路存在
             */
            nexts = new Node[26];   // 若字符过多则使用hashMap
        }
    }


    public static class Node2 {
        public int pass;
        public int end;
        public HashMap<Integer, Node2> nexts;

        public Node2() {
            pass = 0;
            end = 0;
            /**
             * 0    a
             * 1    b
             * ...
             * 25   z
             * next[i]==null    i方向的路不存在
             * next[i]!=null    i方向的路存在
             */
            nexts = new HashMap<>();   // 若字符过多则使用hashMap
        }
    }


}
