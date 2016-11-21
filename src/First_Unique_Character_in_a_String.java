/**
 * Created by Alvin on 16/11/21.
 */

import com.sun.org.apache.xml.internal.utils.Hashtree2Node;

import java.util.HashMap;

/**
 Given a string, find the first non-repeating character in it and return it's index.
 If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 Note: You may assume the string contain only lowercase letters.
 *
 */
public class First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        int[] array = new int[26];
        for (int i = 0 ; i < s.length(); i++){
            array[s.charAt(i)-'a']++;
        }
        for (int i = 0 ; i < s.length(); i++){
            if(array[s.charAt(i)-'a'] == 1)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(new First_Unique_Character_in_a_String().firstUniqChar(s));
    }
}
