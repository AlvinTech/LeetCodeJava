/**
 * Created by Alvin on 16/12/9.
 */
/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

* */
public class Happy_Number {
    public boolean isHappy(int n) {
//        System.out.println(n);
        if(n == 1 || n == 7)
            return true;
        if(n < 10)
            return false;
        int result = 0;
        while(n >0){
            int digit = n % 10;
            result +=  digit* digit;
            n = n / 10;
        }
        return isHappy(result);
    }

    public static void main(String[] args) {
        System.out.println(new Happy_Number().isHappy(9));
    }
}
