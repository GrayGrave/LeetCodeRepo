package 剑指offer;

/**
 * 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 思路：利用位运算  note
 */
public class jz_56_I {
    public int[] singleNumbers(int[] nums) {
        int Xor = 0;
        for (int num : nums) {
            Xor ^= num;
        }
        int hasOne = 1;
        while ((Xor & hasOne) == 0) {
            hasOne <<= 1;
        }
        int half = 0;
        for (int num : nums) {
            if ((num & hasOne) == 0) half ^= num;
        }
        return new int[]{half, Xor ^ half};
    }
}
