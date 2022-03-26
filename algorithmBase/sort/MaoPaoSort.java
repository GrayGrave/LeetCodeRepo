package algorithmBase.sort;

/**
 * 冒泡排序 时间复杂度 O(N^2)
 */
public class MaoPaoSort {
    public static void maoPaoSort(int[] arr) {
        // 记录最后一次交换位置
        int lastExchangeIndex = 0;
        // 无序数列的边界，每次比较只需要比较到这里
        int sortBorder = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            // 有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int tmp = 0;
                if (arr[j] < arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSorted = false;
                    // 更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) break;
        }
    }
}
