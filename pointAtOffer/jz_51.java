package pointAtOffer;

/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 思路：归并排序    todo  需要调试   note 经典好题！
 */
public class jz_51 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

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
