package leetcode.code;

/**
 * 颜色分类
 * 思路：荷兰国旗问题，快排partition动作，将元素往两边"扔"
 */
public class lc_75 {
    public void sortColors(int[] nums) {
        if (nums.length == 0) return;

        int less = -1;
        int more = nums.length;
        int cur = 0;

        while (cur < more) {                   // 结束条件，cur与more指针相遇
            if (nums[cur] == 0) {
                less++;
                swap(nums, less, cur);
                cur++;
            }else if(nums[cur]==1){
                cur++;
            }else {                            // 与more交换之后不知道more交换过来的数字是多少，此时cur不进行cur++
                more--;
                swap(nums,cur,more);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
