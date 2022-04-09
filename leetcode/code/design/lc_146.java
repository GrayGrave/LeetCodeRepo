package leetcode.code.design;

import java.util.HashMap;

/**
 * LRU缓存 ‼️
 */
public class lc_146 {
    class LRUCache {
        private HashMap<Integer, Node> map;
        private DoubleList cache;
        private int cap;            // 缓存容量

        // 初始化 LRU cache 的数据
        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DoubleList();
        }


        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            int val = map.get(key).val;
            put(key, val);
            return val;
        }

        public void put(int key, int val) {
            Node x = new Node(key, val);
            // key存在则更新
            if (map.containsKey(key)) {
                cache.remove(map.get(key));
                cache.addFirst(x);
                map.put(key, x);
            } else {
                // 缓存满则删掉尾部数据再头插入链表
                if (cache.size() == cap) {
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                cache.addFirst(x);
                map.put(key, x);
            }
        }


    }

    class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList {
        //头尾虚节点
        private Node head, tail;
        //链表元素数
        private int size;

        // 构造器初始化
        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        // 直接移除队尾元素，缓存满时需要的操作
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        // 移除并返回队尾元素，进行队列元素更新
        public Node removeLast() {
            if (tail.prev == head) {     // 缓存已经空了
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int size() {
            return size;
        }
    }
}
