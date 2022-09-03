package pointAtOffer;

/**
 * 数组中数字出现的次数 II  doubt
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了【三次】。请找出那个只出现一次的数字。
 * 思路：位运算
 */
public class jz_56_II {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    //  note 左程云解法
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & mask) != 0) cnt++;
            }
            if (cnt % 3 != 0) res |= mask;    //cnt%k 推广到K
        }
        return res;
    }
}
