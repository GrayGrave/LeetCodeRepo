package pointAtOffer;

/**
 * 在排序数组中查找数字
 * 统计一个数字在排序数组中出现的次数。
 * 思路：先寻找数字出现在数组的起始位置(二分法)，再往后查找共出现的次数
 */
public class jz_53_I {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            // note 等于的情况放在更新左边界还是右边界，决定查找数字出现在数组中的起始位数还是结束位置！！
            if (nums[mid] >= target)
                right = mid;
            if (nums[mid] < target)
                left = mid + 1;
        }
        while (left < nums.length && nums[left++] == target)
            count++;
        return count;
    }
}
