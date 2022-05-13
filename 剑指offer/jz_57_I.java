package 剑指offer;

/**
 * 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * 思路：双指针左右往中间逼近   todo
 */
public class jz_57_I {
    public int[] twoSum(int[] nums, int target) {
        //对撞指针
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        //排除两个位置的数相加等于target的情况
        while (left < right) {
            if (target > nums[left] + nums[right]) {
                left++;
            } else if (target < nums[left] + nums[right]) {
                right--;
            } else {
                res[0] = nums[left];
                res[1] = nums[right];
                return res;
            }

        }
        return null;
    }
}
