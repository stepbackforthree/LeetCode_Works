import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Test {
    int result = Integer.MAX_VALUE;

    @org.junit.Test
    public void test() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();

            int remainder = 8 - input.length() % 8;

            int start = 0;

            if (input.length() > 8) {
                while (start < input.length() && start + 8 < input.length()) {
                    String subString = input.substring(start, start + 8);
                    start += 8;
                    System.out.println(subString);
                }
            }

            String remainderString = "";
            String subString = input.substring(input.length() / 8 * 8);

            if (remainder != 0 && remainder != 8) {
                for (int i = 0; i < remainder; ++i) {
                    remainderString += "0";
                }
                System.out.println(subString + remainderString);
            } else {
                System.out.println(input);
            }
        }
    }

    private ListNode reverse(ListNode node) {
        if (node.next == null) {
            return node;
        }

        ListNode head = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return head;
    }
}

class Node {
    int val;
    Node prev;
    Node next;
    Node child;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", prev=" + prev +
                ", next=" + next +
                ", child=" + child +
                '}';
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class Trie {
    Trie[] children;
    Boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
}
