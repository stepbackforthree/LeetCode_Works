//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints.length <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
// Related Topics 数组 数学 字符串 排序 👍 156 👎 0


import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }

        int[] times = new int[timePoints.size()];
        int index = 0;
        for (String time : timePoints) {
            times[index++] = transferToMinutes(time);
        }

        Arrays.sort(times);

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < times.length - 1; ++i) {
            result = Math.min(result, times[i+1] - times[i]);
        }

        return Math.min(result, times[0] + 1440 - times[times.length - 1]);
    }

    int transferToMinutes(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);

        return hour * 60 + minute;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
