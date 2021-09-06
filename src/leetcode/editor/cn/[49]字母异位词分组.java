//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 👍 838 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            String currStr = strs[i];
            String currSortStr = sortString(currStr);

            if (hashMap.containsKey(currSortStr)) {
                List<String> currList = hashMap.get(currSortStr);
                currList.add(currStr);
            } else {
                List<String> currList = new ArrayList<>();
                currList.add(currStr);
                hashMap.put(currSortStr, currList);
            }
        }

//        for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
//            result.add(entry.getValue());
//        }
        hashMap.forEach((k, v) -> result.add(v));

        return result;
    }

    String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
