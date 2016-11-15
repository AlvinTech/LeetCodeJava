/**
 * Created by pengli on 11/15/2016.
 */


/*
*
A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
For example, these are arithmetic sequence:
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.
1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
The function should return the number of arithmetic slices in the array A.

Example:
A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
*
* */
public class Arithmetic_Slices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3){
            return 0;
        }
        int[] key = new int[A.length];
        boolean flag = false;
        int result = 0;
        int big = 0;
        for(int i =2; i < A.length; i++){
            if((A[i] - A[i-1]) ==(A[i-1]- A[i-2])){
                result ++;
            }else{
                if(big < result)
                    big = result;
                key[i-1] = result;
                result =0;
            }
        }
        if(result != 0) {
            if(big < result)
                big = result;
            key[A.length - 1] = result;
        }
        int[] values = count(big);
        result =0;
        for (int i =0 ; i < key.length; i++){
            if(key[i] != 0){
                result += values[key[i]-1];
            }
        }
        return result;
    }

    private int[] count(int n){
        if(n ==0)
            return null;
        int[] values = new int[n];
        values[0]=1;
        for(int i =1 ; i < n ;i++){
            values[i] = values[i-1]+ i+1;
        }
        return values;
    }


    public static void main(String[] args) {
        int[]  A ={1,2,3,4,5,6};
        System.out.println(new Arithmetic_Slices().numberOfArithmeticSlices(A));
    }
}
