import org.junit.Test;

import java.util.*;

public class test {
    @Test
    public void test() {
        int m = 3, n = 7;
        int[][] cache = new int[m][n];
        findNext(m, n, 1, 1, cache);
        System.out.println(cache[0]);
    }

    int findNext(int m, int n, int currM, int currN, int[][] cache) {
        if (currM > m || currN > n) {
            return 0;
        }

        if (currM == m || currN == n) {
            return 1;
        }

        if (cache[currM][currN] != 0) {
            return cache[currM][currN];
        }

        cache[currM][currN] = findNext(m, n, currM + 1, currN, cache) + findNext(m, n, currM, currN + 1, cache);
        return findNext(m, n, currM + 1, currN, cache) + findNext(m, n, currM, currN + 1, cache);

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
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

