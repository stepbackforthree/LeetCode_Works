//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 498 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> listResult = new ArrayList<>();
    boolean[] visited;

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        this.visited = new boolean[s.length()];
        Arrays.sort(chars);

        findNext(chars, new StringBuilder());

        String[] result = new String[listResult.size()];
        for (int i = 0; i < listResult.size(); ++i) {
            result[i] = listResult.get(i);
        }

        return result;
    }

    void findNext(char[] chars, StringBuilder sb) {
        if (sb.length() == chars.length) {
            listResult.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; ++i) {
            if (visited[i] || (i > 0 && !visited[i-1] && chars[i-1] == chars[i])) {
                continue;
            }

            sb.append(chars[i]);
            visited[i] = true;
            findNext(chars, sb);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
