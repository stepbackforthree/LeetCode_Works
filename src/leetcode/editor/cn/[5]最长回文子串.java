class Solution {
    public static String longestPalindrome(String s) {
        int left = 0, right;
        int lastLeft = 0, lastRight = 0;
        if (s.length() == 1) {
            return s;
        }
        while (left != s.length() - 1) {
            int move = right = s.length() - 1;
            if (right - left <= lastRight - lastLeft) {
                break;
            }
            while (right != left - 1) {
                if ((right + left) / 2 == move) {
                    if (right - left > lastRight - lastLeft) {
                        lastLeft = left;
                        lastRight = right;
                    }
                    break;
                }
                if (s.charAt(left + right - move) == s.charAt(move)) {
                    move--;
                } else {
                    move = --right;
                }
            }
            left++;
        }
        return s.substring(lastLeft, lastRight + 1);
    }
}