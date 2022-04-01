package leetcode.code.twoPointer;

/**
 * 盛最多水的容器      找出两条线，使得他们与x轴共同构成的容器可以容纳最多的水
 * 思路：双指针
 */
public class lc_11 {
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            // 获取以当前l、r为边界可以容纳最多的水
            int cur = (r - l) * Math.min(height[l], height[r]);
            // 谁短谁往中间移动
            if (height[l] < height[r]) l++;
            else r--;

            //更新最大值
            res = Math.max(res, cur);
        }
        return res;
    }
}
