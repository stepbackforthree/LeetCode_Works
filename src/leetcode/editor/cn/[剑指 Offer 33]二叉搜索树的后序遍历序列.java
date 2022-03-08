//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 437 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> list = new ArrayList<>();

    public boolean verifyPostorder(int[] postorder) {
        return findNext(postorder, 0, postorder.length - 1);
    }

    boolean findNext(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }

        int pointer = left;
        int leftStart = pointer;
        //左子树小于根元素
        while (postorder[pointer] < postorder[right]) {
            pointer++;
        }
        int leftEnd = pointer - 1;
        int rightStart = pointer;

        //右子树大于根元素
        while (postorder[pointer] > postorder[right]) {
            pointer++;
        }
        int rightEnd = pointer - 1;

        // 1. 检查右子树中有无比根节点小的元素，如果有，遍历会提前停止，pointer不会等于根节点位置
        // 2. 递归的检查当前节点的左子树和右子树是否满足树的二叉树的构成条件
        return pointer == right && findNext(postorder, leftStart, leftEnd) && findNext(postorder, rightStart, rightEnd);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
