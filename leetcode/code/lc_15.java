package leetcode.code;

import java.util.*;

/**
 * 三数之和
 */
public class lc_15 {
    // 寻找三个数，分别为a,b,c    . -> <-
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        int len = nums.length;

        Arrays.sort(nums); // 升序
        for (int i = 0; i < len - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {          // a不重复
                int l = i + 1, r = len - 1, sum = -nums[i];

                // 双指针碰撞
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {       // 出现可行解
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        // 排除重复解
                        while (l < r && nums[l] == nums[l + 1]) l++;  // b不重复
                        while (l < r && nums[r] == nums[r - 1]) r--;  // c不重复
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;        // b不重复
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;       // c不重复
                        r--;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];

            // 双指针
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < sum) {
                    low++;
                } else high--;
            }
        }
        return res;
    }
}

