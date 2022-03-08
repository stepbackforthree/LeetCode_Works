//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 241 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
//        Deque<Integer> deque = new ArrayDeque<>();
//        List<Integer> list = new ArrayList<>();
//
//        while (head != null) {
//            deque.push(head.val);
//            head = head.next;
//        }
//
//        while (!deque.isEmpty()) {
//            list.add(deque.pop());
//        }
//
//        return list.stream().mapToInt(Integer::valueOf).toArray();

        findNext(head);
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); ++i) {
            result[i] = list.get(i);
        }

        return result;
    }

    void findNext(ListNode head) {
        if (head == null) {
            return;
        }

        findNext(head.next);
        list.add(head.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
