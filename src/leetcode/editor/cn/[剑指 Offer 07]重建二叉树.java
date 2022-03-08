//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 667 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
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
    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }

        this.preorder = preorder;

        return findNext(0, 0, inorder.length-1);
    }

    TreeNode findNext(int preorderRootIdx, int inorderLeftIdx, int inorderRightIdx) {
        if (inorderLeftIdx > inorderRightIdx) {
            return null;
        }

        int root = preorder[preorderRootIdx];
        TreeNode head = new TreeNode(root);

        int inorderRootIdx = map.get(root);

        head.left = findNext(preorderRootIdx+1, inorderLeftIdx, inorderRootIdx-1);

        head.right = findNext(inorderRootIdx - inorderLeftIdx + preorderRootIdx + 1, inorderRootIdx+1, inorderRightIdx);

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
