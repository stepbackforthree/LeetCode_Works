//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 254 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    int count;
    int result;
    int k;
    public int kthLargest(TreeNode root, int k) {
        this.count = 0;
        this.k = k;
        findNext(root);
        return result;
    }

    void findNext(TreeNode node) {
        if (node.right != null) {
            findNext(node.right);
        }

        count++;

        if (count == k) {
            result = node.val;
            return;
        }

        if (node.left != null) {
            findNext(node.left);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
