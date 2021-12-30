//给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 
//second 紧随 first 出现，third 紧随 second 出现。 
//
// 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：text = "alice is a good girl she is a good student", first = "a", second = 
//"good"
//输出：["girl","student"]
// 
//
// 示例 2： 
//
// 
//输入：text = "we will we will rock you", first = "we", second = "will"
//输出：["we","rock"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 1000 
// text 由小写英文字母和空格组成 
// text 中的所有单词之间都由 单个空格字符 分隔 
// 1 <= first.length, second.length <= 10 
// first 和 second 由小写英文字母组成 
// 
// Related Topics 字符串 👍 51 👎 0


import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] str = text.split(" ");
        String strResult = "";
        String[] result = new String[0];

        int pointer = 0;

        while (pointer < str.length - 2) {
            if (str[pointer].equals(first)) {
                if (str[pointer+1].equals(second)) {
                    strResult += str[pointer + 2] + " ";
                    if (first.equals(second)) {
                        pointer++;
                    } else {
                        pointer += 2;
                    }
                } else {
                    if (str[pointer+1].equals(first)) {
                        pointer++;
                    } else {
                        pointer += 2;
                    }
                }
            } else {
                pointer++;
            }
        }

        if (!strResult.equals("")) {
            result = strResult.split(" ");
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
