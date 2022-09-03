package pointAtOffer;

/**
 * 0 ~ n-1 中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 */
public class jz_53_II {
    // 异或解法
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int xor = 0;
        for (int i = 0; i < len; i++) {
            xor ^= i;
            xor ^= nums[i];
        }
        return xor ^ len;
    }

    // 二分解法
    public int missingNumber2(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l < r) {                    // 搜索范围为闭区间 [l, r]
            int mid = l + (r - l) / 2;
            if (nums[mid] != mid) {        // 空缺的数字在此处或者左边
                r = mid;
            } else {                      // 空缺的数字在右边  nums[mid]==mid
                l = mid + 1;
            }
        }
        return nums[l] == l ? l + 1 : l;
    }
}
