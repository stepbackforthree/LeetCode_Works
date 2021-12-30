//给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。 
//
// 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。 
//
// 
//
// 示例 1： 
//
// 
//输入：date = "2019-01-09"
//输出：9
// 
//
// 示例 2： 
//
// 
//输入：date = "2019-02-10"
//输出：41
// 
//
// 示例 3： 
//
// 
//输入：date = "2003-03-01"
//输出：60
// 
//
// 示例 4： 
//
// 
//输入：date = "2004-03-01"
//输出：61 
//
// 
//
// 提示： 
//
// 
// date.length == 10 
// date[4] == date[7] == '-'，其他的 date[i] 都是数字 
// date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日 
// 
// Related Topics 数学 字符串 👍 76 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dayOfYear(String date) {
        String[] list = date.split("-");
        int year = Integer.parseInt(list[0]);
        int month = Integer.parseInt(list[1]);
        int day = Integer.parseInt(list[2]);

        int result = 0;

        if ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)) {
            for (int m = 1; m < month; ++m) {
                switch (m) {
                    case 1, 3, 5, 7, 8, 10, 12 -> result += 31;
                    case 2 -> result += 29;
                    default -> result += 30;
                }
            }
        } else {
            for (int m = 1; m < month; ++m) {
                switch (m) {
                    case 1, 3, 5, 7, 8, 10, 12 -> result += 31;
                    case 2 -> result += 28;
                    default -> result += 30;
                }
            }
        }
        return result + day;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
