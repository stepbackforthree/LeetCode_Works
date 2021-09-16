//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 967 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return findNext(root.left, root.right);
        }
    }

    int findNext(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return 1;
        }

        if (right == null) {
            return 1 + findNext(left.left, left.right);
        } else if (left == null) {
            return 1 + findNext(right.left, right.right);
        } else {
            return 1 + Math.max(findNext(left.left, left.right), findNext(right.left, right.right));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
