//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
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
// -100 <= Node.val <= 100 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 577 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root != null) {
            findNext(root, 0);
        }

        return result;
    }

    void findNext(TreeNode curr, int layer) {
        if (curr == null) {
            return;
        }

        if (result.size() == layer) {
            result.add(new ArrayList<>());
        }

        result.get(layer).add(curr.val);
        if (layer % 2 != 0) {
            findNext(curr.left, layer+1);
            findNext(curr.right, layer+1);
        } else {
            findNext(curr.right, layer+1);
            findNext(curr.left, layer+1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
