//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治算法 
// 👍 4057 👎 0


import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double midSearch(int [] nums) {
        int mid = nums.length / 2;
        if (nums.length % 2 == 0) {
            return ((double) nums[mid] + (double) nums[mid - 1]) / 2;
        } else {
            return nums[mid];
        }
    }

    public void bubbleSort(int[] nums) {
        int complete = 0;
        while (complete != nums.length - 1) {
            for (int i = 0; i < nums.length - complete - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                }
            }
            complete++;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums2.length == 0 ? 0 : midSearch(nums2);
        }
        if (nums2.length == 0) {
            return midSearch(nums1);
        }

        int[] nums = new int[nums1.length + nums2.length];
        int count = 0;
        for (int i : nums1) {
            nums[count++] = i;
        }
        for (int i : nums2) {
            nums[count++] = i;
        }
        bubbleSort(nums);

        int mid = nums.length / 2;
        if (nums.length % 2 == 0) {
            return ((double) nums[mid] + (double) nums[mid - 1]) / 2;
        }
        return nums[mid];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
