package algorithmBase.sort;

public class PartitionAndQuickSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 小于等于区推着往右扩张
    // 划分区域，左边小于等于基准值，右边大于基准值
    public static int partition(int[] arr, int l, int r) {
        if (l > r) return -1;
        if (l == r) return l;
        int lessEqual = l - 1;  // 小于等于区初始位置
        int index = l;
        while (index < r) {
            if (arr[index] <= arr[r]) {  // 以数组右边界数值为基准，也可以选择其他数值
                swap(arr, index, ++lessEqual);  // 往右扩张
            }
            index++;
        }
        swap(arr, ++lessEqual, r);   // note  直接合并在while（）中 ？ => r位置为基准值最后处理，某些问题需要特殊处理
        return lessEqual;   // 返回基准值下标
    }

    /**
     * 荷兰🇳🇱国旗问题，即划分三个区域，<、=、>,返回区域划分的两个分界下标
     * 0123 444 69873  第一个4和最后一个4的下标，即4的区域[]
     */
    public static int[] netherlandFlag(int[] arr, int l, int r) {
        if (l > r) return new int[]{-1, -1};
        if (l == r) return new int[]{l, r};

        int less = l - 1;
        int more = r;       // r位置数值是基准值具有特殊性，最后需要特殊处理，故more边界先左移一步
        int index = l;
        while (index < more) {
            if (arr[index] == arr[r]) {
                index++;
            } else if (arr[index] < arr[r]) {
                swap(arr, index++, ++less);  // less 区间右扩
            } else {
                // more 区间左扩，从右边交换过来的值无法确定和arr[r]的大小，故需要再次比较，此不进行index++
                swap(arr, index, arr[--more]);
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};   // 经过最后的一步swap，more位置已经是基准值了
    }

    public static void quickSort(int[] arr) {   // 如果输入参数有l,r可以直接进行递归，此处需要再调用process进行递归处理
        if (arr == null || arr.length < 2) return;
        process1(arr, 0, arr.length - 1);
    }

    // 快排 v1.0   O(N^2)
    private static void process1(int[] arr, int l, int r) {
        if (l >= r) return;     // 边界条件

        int pivotIndex = partition(arr, l, r); // 获取基准值下标
        process1(arr, l, pivotIndex - 1);    // 左边递归
        process1(arr, pivotIndex + 1, r);    // 右边递归
    }

    // 快排 v2.0   O(N^2)
    private static void process2(int[] arr, int l, int r) {
        if (l >= r) return;     // 边界条件

        int[] equalArea = netherlandFlag(arr, l, r); // 中间等于基准值的部分直接跳过，加快排序速度
        process2(arr, l, equalArea[0] - 1);    // 左边递归
        process2(arr, equalArea[1] + 1, r);    // 右边递归
    }


    // 快排 v3.0   随机选取选取一个与最后一个位置交换作为基准值   经典快排  O(NlogN)
    private static void process3(int[] arr, int l, int r) {
        if (l >= r) return;     // 边界条件

        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);   // Math.random() [0,1)
        int[] equalArea = netherlandFlag(arr, l, r); // 中间等于基准值的部分直接跳过，加快排序速度
        process3(arr, l, equalArea[0] - 1);    // 左边递归
        process3(arr, equalArea[1] + 1, r);    // 右边递归
    }

}














