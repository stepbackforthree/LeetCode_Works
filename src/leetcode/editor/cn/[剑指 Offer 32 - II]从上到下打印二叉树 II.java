//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-
//traversal/ 
// Related Topics 树 广度优先搜索 二叉树 👍 178 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        findNext(root, 0);

        for (int i = 0; i < map.size(); ++i) {
            result.add(map.get(i));
        }

        return result;
    }

    void findNext(TreeNode node, int layer) {
        if (node == null) {
            return;
        }

        List<Integer> subList = map.getOrDefault(layer, new ArrayList<>());
        subList.add(node.val);
        map.put(layer, subList);

        findNext(node.left, layer+1);
        findNext(node.right, layer+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
