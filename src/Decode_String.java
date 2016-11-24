import java.util.Stack;

/**
 * Created by Alvin on 16/11/23.
 */
/*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
* */
public class Decode_String {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        String result = new String();
        for(int i =0 ; i < s.length(); i++){
            if(s.charAt(i) == ']'){
                String c = stack.pop();
                String temp = new String();

                while(!c.equals("[")){
                    temp = c + temp;
                    c = stack.pop();
                }

                String sk = new String();
                c = stack.peek();
                while(c.charAt(0) >= '0' && c.charAt(0) <='9'){
                    c = stack.pop();
                    sk = c+sk;
                    if(stack.isEmpty()){
                        break;
                    }
                    c = stack.peek();
                }

                String value = new String();
                for (int j =0 ; j < Integer.valueOf(sk); j++){
                    value = value + temp;
                }
                stack.push(value);

            }else{
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
       // System.out.println(stack);
        while(!stack.isEmpty()){
            result = stack.pop() + result;
        }
        return result;
    }

    public static void main(String[] args) {
        String s ="2[abc]3[cd]ef";
        System.out.println(new Decode_String().decodeString(s));
    }
    abcabccdcdcdef
    abcabccdcdcdef
}
