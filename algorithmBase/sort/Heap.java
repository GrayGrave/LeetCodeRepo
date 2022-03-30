package algorithmBase.sort;

import java.util.PriorityQueue;

/**
 * 堆 => 大根堆、小根堆
 * 数组表示堆[0,1,..,n]，父节点 (i-1)/2、左子节点 2*i+1 、右子节点2*i+2
 * 进阶: 实现resign方法，即放入堆的是实际对象如student，堆排好序之后，修改了其中某个student的属性值(排序的依据)，然后
 * 重新按照比较器的规则对堆中的对象进行调整。
 * （系统提供的堆无法实现该功能，即使提供了代价也很高，需要自己实现，迪杰斯特拉算法会用到该方法）
 */

public class Heap {
    public static void main(String[] args) {
        // 系统提供的堆，默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 自己实现的堆
        Heap myHeap = new Heap(100);
    }

    private int[] heap;
    private final int limit;
    private int heapSize;

    public Heap(int limit) {
        this.limit = limit;
        heap = new int[limit];
        heapSize = 0;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    public void push(int value) {
        if (heapSize == limit) {
            throw new RuntimeException("heap is full");
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize++);
    }

    public int pop() {
        int ans = heap[0];
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return ans;
    }


    //  堆排序算法 O(NlogN)  额外空间复杂度O(1)
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        // 建堆 O(NlogN)
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);

        // 排序 O(NlogN)
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }


    // 堆末尾插入，往上浮   O(logN)   （建堆过程）
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {     // 大根堆
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 堆顶弹出，堆末尾占据堆顶，往下沉  O(logN)   （重新调整过程）
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            // note  left + 1 = heapSize?  => heapSize 是指向最后元素的下一个位置
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) break;
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}

