//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// Related Topics 数组 前缀和 👍 203 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
        if (a.length < 2) {
            return new int[0];
        }

        int[] prefixMultiple = new int[a.length+1];
        int[] suffixMultiple = new int[a.length+1];
        prefixMultiple[0] = 1;
        suffixMultiple[a.length] = 1;

        for (int i = 1; i <= a.length; ++i) {
            prefixMultiple[i] = prefixMultiple[i-1] * a[i-1];
            suffixMultiple[a.length - i] = suffixMultiple[a.length - i + 1] * a[a.length - i];
        }

        int[] result = new int[a.length];

        for (int i = 1; i < result.length - 1; ++i) {
            result[i] = prefixMultiple[i] * suffixMultiple[i+1];
        }

        result[0] = suffixMultiple[1];
        result[a.length - 1] = prefixMultiple[a.length - 1];

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
