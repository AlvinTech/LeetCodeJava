import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alvin on 16/11/25.
 */
/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

Credits:
Special thanks to @minglotus6 for adding this problem and creating all test cases.
* */
public class Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map = new HashMap<>();
        String[] values = str.split(" ");
        if(values.length != pattern.length())
            return  false;
        for (int i =0 ; i < pattern.length(); i++){
            char c= pattern.charAt(i);
            if(map.get(c) ==null){
                if(map.containsValue(values[i])){
                    return false;
                }
                map.put(c,values[i]);
            }
            else{
                if(!values[i].equals(map.get(c))){
                  //  System.out.println(values[i]);
                    //System.out.println(map.get(c));
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern ="abab";
        String str= "dog dag dog dag";
        System.out.println(new Word_Pattern().wordPattern(pattern,str));
    }
}
