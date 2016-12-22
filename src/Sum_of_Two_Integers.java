/**
 * Created by Alvin on 16/12/21.
 */

/**
 Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.

 Credits:
 Special thanks to @fujiaozhu for adding this problem and creating all test cases.
 */
public class Sum_of_Two_Integers {
    public int getSum(int a, int b) {
        while(b != 0){
            int value = a & b;
            a = a ^ b;
            b = value << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Sum_of_Two_Integers().getSum(191,19));
    }
}
