package leetcode.code;

import java.util.Arrays;

/**
 * 会议室
 * 给定一个包含开始和结束时间的会议时间数组[[s1,e1],[s2,e2],...] (si < ei),判断一个人是否可以参加全部的会议。
 * 思路：先将数组按开始时间排序,然后比较前一个的结束时间和后一个的开始时间即可
 */
public class lc_252 {
    public boolean minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);  // 以区间开始端位置进行升序

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
