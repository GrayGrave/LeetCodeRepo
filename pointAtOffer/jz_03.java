package pointAtOffer;

/**
 * 数组中重复的数字
 * 思路：扫描数组让每个数字进行"归位"，遇到相同归位则说明出现重复数字。
 */
public class jz_03 {
    public int findRepeatNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                if (nums[i] != nums[nums[i]]) {
                    // 数字"归位"
                    int tmp = nums[i];
                    nums[i] = nums[tmp];
                    nums[tmp] = tmp;
                } else {
                    // 出现重复数字
                    res = nums[i];
                    break;
                }
            }
        }
        return res;
    }
}
