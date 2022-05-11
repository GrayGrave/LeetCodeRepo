package 剑指offer;

/**
 * 数组中出现次数超过一半的数字
 * 思路：摩尔投票法(类似打擂台)  时间复杂度O(N)
 */
public class jz_39 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int card = 0;
        for (int num : nums) {
            if (count == 0) {
                card = num;    // 确定擂台上的数字
            }
            count += (num == card) ? 1 : -1;
        }
        return card;
    }
}
