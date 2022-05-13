package 剑指offer;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 思路：排序加遍历
 */
public class jz_61 {
    public boolean isStraight(int[] nums) {
        if (nums == null) return false;
        int zeroCount = 0;
        int skipCount = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i] && nums[i] != 0) return false;
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                skipCount += nums[i + 1] - nums[i] - 1;
            }
        }
        return zeroCount >= skipCount;
    }
}
