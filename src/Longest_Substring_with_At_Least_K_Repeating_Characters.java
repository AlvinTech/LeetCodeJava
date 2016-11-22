/**
 * Created by Alvin on 16/11/16.
 */

/**
 Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

 Example 1:

 Input:
 s = "aaabb", k = 3

 Output:
 3

 The longest substring is "aaa", as 'a' is repeated 3 times.
 Example 2:

 Input:
 s = "ababbc", k = 2

 Output:
 5

 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class Longest_Substring_with_At_Least_K_Repeating_Characters {
    public int longestSubstring(String s, int k) {
        int lenth = s.length();
        if(k ==1)
            return  lenth;
        int[] values = new int[26];
        for (int i = 0 ; i < lenth; i++){
            values[s.charAt(i)-'a']++;
        }
        for (int i = 0 ; i < values.length; i++){
            if(values[i] > 0 && values[i] < k){
                s = s.replaceAll(String.valueOf((char)(i+'a'))," ");
            }
        }
        int max = 0;
        String[] subs = s.trim().split(" ");
        if(subs.length == 1)
            return subs[0].length();
        else{
            for (String sub : subs){
                if(longestSubstring(sub, k) > max){
                    max = longestSubstring(sub, k);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        String s = "bbaaacbd";
        int k  = 3;
        System.out.println(new Longest_Substring_with_At_Least_K_Repeating_Characters().longestSubstring(s, k));
    }
}
/*
*  暴力破解的方法肯定不行，先拆分字符串，然后在循环判断sub string。
*  由于用到了很多string的自带方法，所以这个解法不是很好，如果有好的思路，欢迎提供。
*
* */