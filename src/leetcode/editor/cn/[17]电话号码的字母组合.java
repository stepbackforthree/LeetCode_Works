//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1463 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<String, List<String>> phoneButton = new HashMap<>();
        phoneButton.put("1", new ArrayList<>(Arrays.asList("!", "@", "#")));
        phoneButton.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
        phoneButton.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
        phoneButton.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
        phoneButton.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
        phoneButton.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
        phoneButton.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        phoneButton.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
        phoneButton.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));

        List<String> result = new ArrayList<>();
        if (digits.length() == 1) {
            result = phoneButton.get(digits);
        } else if (digits.length() > 1) {
            String[] digitsCollection = digits.split("");
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < digitsCollection.length; i++) {
                List<String> selectDigit = phoneButton.get(digitsCollection[i]);
                if (i == 0) {
                    temp.addAll(selectDigit);
                } else {
                    List<String> tempTemp = new ArrayList<>();
                    for (String s : temp) {
                        for (String value : selectDigit) {
                            tempTemp.add(s + value);
                        }
                    }
                    temp = tempTemp;
                }
            }
            result = temp;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
