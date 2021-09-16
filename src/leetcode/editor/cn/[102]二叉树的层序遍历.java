//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1013 👎 0


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
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root != null) {
            List<Integer> subResult = new ArrayList<>();
            subResult.add(root.val);
            result.add(subResult);
            Map<Integer, List<Integer>> hashMap = new HashMap<>();
            findNext(root.left, root.right, 1, hashMap);

            for (Map.Entry<Integer, List<Integer>> entry : hashMap.entrySet()) {
                result.add(entry.getValue());
            }
        }

        return result;
    }

    void findNext(TreeNode left, TreeNode right, int layer, Map<Integer, List<Integer>> hashMap) {
        if (left == null && right == null) {
            return;
        }

        List<Integer> subResult = hashMap.getOrDefault(layer, new ArrayList<>());
        if (left != null) {
            subResult.add(left.val);

        }
        if (right != null) {
            subResult.add(right.val);
        }
        hashMap.put(layer, subResult);

        if (left != null) {
            findNext(left.left, left.right, layer + 1, hashMap);
        }

        if (right != null) {
            findNext(right.left, right.right, layer + 1, hashMap);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
