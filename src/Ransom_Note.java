import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alvin on 16/12/6.
 */

/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
* */
public class Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return  false;
        Map<Character, Integer> MagazineMap = new HashMap<>();

        for (int i =0 ; i < magazine.length(); i++){
            char c = magazine.charAt(i);
            if(MagazineMap.containsKey(c)){
                MagazineMap.put(c,MagazineMap.get(c)+1);
            }else {
                MagazineMap.put(c,1);
            }
        }

        for (int i =0 ; i < ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            if((!MagazineMap.containsKey(c)) || (MagazineMap.get(c) <=0))
                return false;
            else{
                MagazineMap.put(c,MagazineMap.get(c)-1);
            }

        }
        return true;
    }
}
