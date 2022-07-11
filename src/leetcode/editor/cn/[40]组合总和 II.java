//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 863 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        Deque<Integer> list = new LinkedList<>();

        findNext(candidates, 0, target, list);

        return result;
    }

    void findNext(int[] candidates, int currIdx, int target, Deque<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (currIdx >= candidates.length) {
            return;
        }

        if (candidates[currIdx] > target) {
            return;
        }

        for (int i = currIdx; i < candidates.length; ++i) {
            if (i > currIdx && candidates[i] == candidates[i-1]) {
                continue;
            }

            list.addLast(candidates[i]);
            findNext(candidates, i+1, target-candidates[i], list);
            list.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
