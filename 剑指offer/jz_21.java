package 剑指offer;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分
 * 思路：荷兰国旗问题降级版
 */
public class jz_21 {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            while (nums[i] % 2 == 1 && i < j) i++;
            while (nums[j] % 2 == 0 && i < j) j--;
            change(nums, i, j);
        }
        return nums;
    }

    public void change(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

