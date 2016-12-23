import java.util.Arrays;

/**
 * Created by Alvin on 16/12/23.
 */
public class Longest_Palindrome {
    public int longestPalindrome(String s) {
        int[] arrays = new int[70];
        for (int i = 0 ; i < s.length(); i++){
            arrays[s.charAt(i)-'A']++;
        }

        int total = 0;
        int max = 0;
        System.out.println(Arrays.toString(arrays));
        for (int i =0 ; i < arrays.length; i++){
            if(arrays[i] % 2 == 0){
                total += arrays[i];
            }else{
                total += arrays[i] -1;
                max = 1;// the letter of the middle of the palindrome
            }
        }
        return total + max;
    }

    public static void main(String[] args) {
        String s= "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(s.length());
        System.out.println(new Longest_Palindrome().longestPalindrome(s));
    }
}
