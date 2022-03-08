//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。 
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。 
//
// 
//
// 示例： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
//binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 266 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    Map<Integer, List<String>> map = new HashMap<>();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        findNext(root, 0);
        String result = "";

        for (int i = 0; i < map.size() - 1; ++i) {
            List<String> subList = map.get(i);

            for (int j = 0; j < subList.size(); ++j) {
                result += subList.get(j);
                if (i != map.size() - 2 || j != subList.size() - 1) {
                    result += ",";
                }
            }
        }

        return result;
    }

    void findNext(TreeNode node, int layer) {
        List<String> subList = map.getOrDefault(layer, new ArrayList<>());
        subList.add(node == null ? "null" : node.val + "");
        map.put(layer, subList);

        if (node == null) {
            return;
        }

        findNext(node.left, layer+1);
        findNext(node.right, layer+1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        String[] result = data.split(",");

        int index = 1;
        Deque<TreeNode> currQueue = new ArrayDeque<>();
        Deque<TreeNode> nextQueue = new ArrayDeque<>();
        TreeNode head = new TreeNode(Integer.parseInt(result[0]));
        currQueue.offer(head);

        while (index < result.length) {
            while (!currQueue.isEmpty()) {
                TreeNode curr = currQueue.poll();
                TreeNode left = null, right = null;
                if (!result[index].equals("null")) {
                    left = new TreeNode(Integer.parseInt(result[index]));
                    nextQueue.offer(left);
                }
                index++;
                if (!result[index].equals("null")) {
                    right = new TreeNode(Integer.parseInt(result[index]));
                    nextQueue.offer(right);
                }
                index++;

                curr.left = left;
                curr.right = right;
            }

            currQueue = nextQueue;
            nextQueue = new ArrayDeque<>();
        }

        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
