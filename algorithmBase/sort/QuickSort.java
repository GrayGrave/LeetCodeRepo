package algorithmBase.sort;

/**
 * 随机快排思路：
 * 随机选取num，使左边分区都小于等于num，右边分区都大于等于num
 * 左右分区递归进行上述操作
 */

public class QuickSort {
    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return; // 边界条件
        // 获得基准元素的位置
        int pivotIndex = partition(arr, l, r);
        // 左右区间分别进行递归
        quickSort(arr, l, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {  // todo ??
        int pivot = arr[l];
        int mark = l;

        for (int i = l; i <= r; i++) {
            if (arr[i] < pivot) {
                mark++;
                int tmp = arr[i];
                arr[i] = arr[mark];
                arr[mark] = tmp;
            }
        }
        arr[l] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

}
