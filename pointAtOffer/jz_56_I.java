package pointAtOffer;

/**
 * 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了【两次】。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 思路：利用位运算    异或操作 => 相同为0，不同为1
 * note 1、任何一个数字异或它自己都等于0  2、任何数异或0都等于0
 * note 即从头到尾依次异或数组中的每个数字，则最终的结果就是那个只出现一次的数字，因为其他出现两次的数字都在异或中抵消了。
 */
public class jz_56_I {
    public int[] singleNumbers(int[] nums) {
        int Xor = 0;
        for (int num : nums) {
            Xor ^= num;
        }

        // 找出只出现一次的两个数的不同位（对应Xor位置的数为1），根据这个位置是1还是0，将原来的数组分为两个子数组
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
