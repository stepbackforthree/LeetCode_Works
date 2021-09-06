//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 👍 1525 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode countHead = head;
        ArrayList<ListNode> nodeCollection = new ArrayList<ListNode>();
        while (countHead != null) {
            nodeCollection.add(countHead);
            count++;
            countHead = countHead.next;
        }

        if (count == 1) {
            return null;
        } else {
            int pre = count - n - 1;
            int next = count - n + 1;
            if (next == count) {
                nodeCollection.get(pre).next = null;
            } else if (pre == -1) {
                return nodeCollection.get(1);
            } else {
                nodeCollection.get(pre).next = nodeCollection.get(next);
            }
            return nodeCollection.get(0);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
