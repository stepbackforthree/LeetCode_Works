import org.junit.Test;

import java.util.*;


public class Main {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return string字符串
     */
    @Test
    public void unique_string () {
        // write code here
        String s = "aab";
        Set<Character> hashSet = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (!hashSet.contains(s.charAt(i))) {
                result.append(s.charAt(i));
                hashSet.add(s.charAt(i));
            }
        }

        System.out.println(result.toString());
    }
}
