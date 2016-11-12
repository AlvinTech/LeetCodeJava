/**
 * Created by Alvin on 16/11/12.
 */


/*
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

        Example:

        Input:
        [1,2,3]

        Output:
        3

        Explanation:
        Only three moves are needed (remember each move increments two elements):

        [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

*/

public class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int total = 0;
        int size = nums.length;
        boolean same = true;
        for(int value : nums){
            if(value != min)
                same = false;
            if(value < min){
                min = value;
            }
            total += value;
        }
        if(same)
            return 0;
        else
            return total - size*min;
    }

    public static void main(String[] args) {
        int[] nums ={1,9};
        System.out.println(new Solution().minMoves(nums));
    }
}
