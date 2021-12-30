import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.*;

public class test {
    @Test
    public void test() {
        int[] ages = {53,109,24,35,22,37,58,99,26,70,22,81,30,36,69};
        System.out.println(numFriendRequests(ages));
    }

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int result = 0;

        for (int i = ages.length - 1; i > 0; --i) {
            int num = i - binarySearch(0, i, i, ages);
            result += Math.max(num, 0);
            int j = i;
            while (j > 0 && ages[j] > ages[j] / 2 + 7 && ages[j] == ages[j-1]) {
                result++;
                j--;
            }
        }

        return result;
    }

    int binarySearch(int left, int right, int index, int[] ages) {
        int target = ages[right] / 2 + 7;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (ages[mid] == target && mid != index) {
                int j = mid;
                while (j < ages.length - 1 && ages[j] == ages[j+1]) {
                    mid++;
                    j++;
                }
                return mid + 1;
            } else if (ages[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
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

