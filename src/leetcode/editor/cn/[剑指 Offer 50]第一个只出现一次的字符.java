//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 👍 184 👎 0


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        Set<Character> hashSet = new HashSet<>();

        for (int i = 0; i < s.length(); ++i) {
            if (!hashSet.contains(s.charAt(i))) {
                queue.offer(s.charAt(i));
                hashSet.add(s.charAt(i));
            } else {
                queue.remove(s.charAt(i));
            }
        }

        return queue.isEmpty() ? ' ' : queue.poll();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
