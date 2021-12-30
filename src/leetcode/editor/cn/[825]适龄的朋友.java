//在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。 
//
// 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求： 
//
// 
// age[y] <= 0.5 * age[x] + 7 
// age[y] > age[x] 
// age[y] > 100 && age[x] < 100 
// 
//
// 否则，x 将会向 y 发送一条好友请求。 
//
// 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。 
//
// 返回在该社交媒体网站上产生的好友请求总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：ages = [16,16]
//输出：2
//解释：2 人互发好友请求。
// 
//
// 示例 2： 
//
// 
//输入：ages = [16,17,18]
//输出：2
//解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
// 
//
// 示例 3： 
//
// 
//输入：ages = [20,30,100,110,120]
//输出：3
//解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
// 
//
// 
//
// 提示： 
//
// 
// n == ages.length 
// 1 <= n <= 2 * 10⁴ 
// 1 <= ages[i] <= 120 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 150 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int numFriendRequests(int[] ages) {
//        Arrays.sort(ages);
//        int result = 0;
//
//        for (int i = ages.length - 1; i > 0; --i) {
//            int num = i - binarySearch(0, i, i, ages);
//            result += Math.max(num, 0);
//            int j = i;
//            while (j > 0 && ages[j] > ages[j] / 2 + 7 && ages[j] == ages[j-1]) {
//                result++;
//                j--;
//            }
//        }
//
//        return result;
//    }
//
//    int binarySearch(int left, int right, int index, int[] ages) {
//        int target = ages[right] / 2 + 7;
//
//        while (left <= right) {
//            int mid = (left + right) / 2;
//
//            if (ages[mid] == target && mid != index) {
//                int j = mid;
//                while (j < ages.length - 1 && ages[j] == ages[j+1]) {
//                    mid++;
//                    j++;
//                }
//                return mid + 1;
//            } else if (ages[mid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return left;
//    }
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int left = 0, right = 0, ans = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                ++left;
            }
            while (right + 1 < n && ages[right + 1] <= age) {
                ++right;
            }
            ans += right - left;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
