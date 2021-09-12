//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1319 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int length;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        this.length = nums.length;
        findNext(nums, 0, new ArrayList<>());
        return result;
    }

    void findNext(int[] nums, int currIdx, List<Integer> subList) {
        if (subList.size() == length) {
            return;
        } else {
            for (int i = currIdx; i < nums.length && !subList.contains(nums[i]); ++i) {
                List<Integer> temp = new ArrayList<>(subList);
                temp.add(nums[i]);
                result.add(temp);
                findNext(nums, currIdx + 1, temp);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
