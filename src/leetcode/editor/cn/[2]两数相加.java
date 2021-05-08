
import java.util.ArrayList;
// Definition for singly-linked list.
//public class ListNode {
//  int val;
//  ListNode next;
//  ListNode() {}
//  ListNode(int val) { this.val = val; }
//  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

class Solution {
    public static void addListNode(ListNode l, int val) {
        if (l.next == null) {
            ListNode newNode = new ListNode(val);
            l.next = newNode;
        } else {
            addListNode(l.next, val);
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> sum = new ArrayList<>();
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum.add(l1.val + l2.val);
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                sum.add(l1.val);
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                sum.add(l2.val);
                l2 = l2.next;
            }
        }
        int size = sum.size();
        int i;
        for (i = 0; i < size; i++) {
            if (sum.get(i) > 9) {
                if (i == size - 1) {
                    sum.add(1);
                } else {
                    sum.set(i + 1, sum.get(i + 1) + 1);
                }
                sum.set(i, sum.get(i) - 10);
            }
        }
        size = sum.size();
        ListNode result = new ListNode(sum.get(0));
        for (i = 0; i < size; i++) {
            if (i == 0) {
                continue;
            }
            addListNode(result, sum.get(i));
        }
        return result;
    }
}
