package leetcode.code;

/**
 * 计算右侧小于当前元素的个数，即计算左侧大于当前元素的个数
 * 解法：归并排序，merge 时压榨出"逆序对"
 */

// note 直接计算右侧小于当前元素的个数，不转化成计算左侧大于当前元素个数，应该怎么考虑相等时先拷贝哪边数组里面的值？？？
public class lc_315 {

    /* 计算数组的小和: 计算左侧小于当前元素的数值之和，即计算右侧大于当前元素的数值之和 */
    // arr[l..r]既要排好序，也要求小和返回
    // 左边排序 merge 时产生小和
    // 右边排序 merge 时产生小和
    // 自身整体 merge 时产生小和
    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {   // base case 即区间就一个数，天然有序，无小和产生
            return 0;
        }
        int mid = (l + r) / 2;          // l/2+((r-l)>>1)
        return mergeSort(arr, l, mid)
                + mergeSort(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l, p2 = mid + 1;   // 左右两边序列的开始索引
        int res = 0;

        while (p1 <= mid && p2 <= r) {
            // 写法二： help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            // res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            if (arr[p1] < arr[p2]) {               // todo 注意：如果是求左边比右边大的数，则相等时需要拷贝左组中的数，p1加1
                help[i++] = arr[p1++];
                res += (r - p2 + 1) * arr[p2];    //  即 p2 右边的数都比 arr[p2] 大
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
        return res;
    }
}
