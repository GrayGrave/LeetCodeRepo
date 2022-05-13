package leetcode.code;

/**
 * 轮转数组     末尾元素插入首部记作轮转一个位置
 * [0,1,2,3,4,5,6] -> [4,5,6,0,1,2,3] 轮转3个位置
 * 思路：三次反转
 */
public class lc_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;   // 轮转n个位置，即数组回到了原来的状态

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
    }
}
