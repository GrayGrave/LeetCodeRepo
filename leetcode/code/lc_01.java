package leetcode.code;

import java.util.HashMap;

public class lc_01 {
    public int[] twoSum(int[] nums, int target) {
        // 边界检查
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }

        int[] res = new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();   // key 为数组中元素的值，value 为对应的下标
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;

    }
}
