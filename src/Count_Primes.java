import java.util.Arrays;

/**
 * Created by Alvin on 16/11/23.
 */

/*
Description:

Count the number of prime numbers less than a non-negative number, n.
* */
public class Count_Primes {
    public int countPrimes(int n) {
        boolean[] falg = new boolean[n];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            //不要每个格子都遍历，也不要用 % 去计算能不能整除
            for (int j = i; j < n; j += i) {
                if (falg[j] == false && j != i) {
                    falg[j] = true;
                }
            }
        }
        int count = 0;
        //        System.out.println(Arrays.toString(falg));
        for (int j = 2; j < n; j++) {
            if (falg[j] == false) {
                //                System.out.println(j);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Count_Primes().countPrimes(7));
    }
}

/*
http://www.cnblogs.com/grandyang/p/4462810.html
* */
