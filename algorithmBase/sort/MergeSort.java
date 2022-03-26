package algorithmBase.sort;

/**
 * 归并排序 【本质思想：不浪费每一次比较】
 * 递归思路：递归执行以下步骤     时间复杂度O(NlogN)
 * 1、左边有序
 * 2、右边有序
 * 3、申请temp空间使整体有序
 * 4、刷回原来空间
 * <p>
 * 非递归思路：                  时间复杂度O(NlogN)
 * mergesize 从1开始指数增加，直至达到数组长度，逐步完成排序
 * 1、-- -- -- -- -- --
 * 2、---- ---- ----
 * 3、------- ----
 * 4、-----------
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {11, 23, 45, 67, 2, 7, 3, 0, 34, 89, 45, 34, 29, 18};
        // mergeSort(arr, 0, arr.length - 1);
        mergeSort2(arr);

        for (int j : arr) {
            System.out.println(j);
        }
    }

    /**
     * 递归版本
     */
    // 使 arr[l..R]范围内有序
    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {   // base case 即区间就一个数，天然有序
            return;
        }
        int mid = (l + r) / 2;              // l/2+((r-l)>>1)
        mergeSort(arr, l, mid);             // 使左边有序
        mergeSort(arr, mid + 1, r);      // 使右边有序
        merge(arr, l, mid, r);              // 合并两个有序序列
    }


    /**
     * 非递归版本
     */
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) return;

        int N = arr.length;
        int mergesize = 1;       // 初始mergesize，即当前有序的左组长度
        while (mergesize < N) {  // 增大合并的粒度
            int l = 0;

            while (l < N) {      // 从左往右遍历进行合并
                // l..m 为左组的范围(mergesize)
                int m = l + mergesize - 1;
                if (m >= N) break;  // 无法凑齐两组进行merge，故跳过 ？

                // l..m 左组    m+1..r 右组
                int r = Math.min(m + mergesize, N - 1);
                merge(arr, l, m, r);
                l = r + 1;
            }

            if (mergesize > N / 2) break;   // 防止 mergesize << 1 溢出,int 最大值 21亿多
            mergesize <<= 1;
        }

    }


    // 合并两个有序序列
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l, p2 = mid + 1;   // 左右两边序列的开始索引

        while (p1 <= mid && p2 <= r) {
            // 写法二： help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            if (arr[p1] < arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }
        // 当一边已经完成合并时，需要将另一边的数据，直接复制到help数组的剩余部分
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        // help刷回原来的数组空间
        for (int j = 0; j < i; j++) {
            arr[l++] = help[j];
        }
    }
}









