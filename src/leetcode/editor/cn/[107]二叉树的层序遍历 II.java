//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 536 👎 0


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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root != null) {
            Map<Integer, List<Integer>> map = new HashMap<>();

            findNext(root, 0, map);

            for (int i = map.size() - 1; i >= 0; --i) {
                result.add(map.get(i));
            }
        }

        return result;
    }

    void findNext(TreeNode node, int layer, Map<Integer, List<Integer>> map) {
        if (node != null) {
            List<Integer> subResult = map.getOrDefault(layer, new ArrayList<>());

            subResult.add(node.val);
            map.put(layer, subResult);

            findNext(node.left, layer+1, map);
            findNext(node.right, layer+1, map);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
