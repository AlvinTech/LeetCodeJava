import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alvin on 16/12/27.
 */

/*
Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
* */
public class Minimum_Moves_to_Equal_Array_Elements_II {
    public int minMoves2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums){
            list.add(i);
        }
        Collections.sort(list);
        int mid  = list.get(nums.length / 2);
        int result = 0;
        for (int value : list){
            result += (value > mid ? value - mid : mid - value);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums ={ 1,2,3};
        System.out.print(new Minimum_Moves_to_Equal_Array_Elements_II().minMoves2(nums));
    }
}


//http://blog.csdn.net/liuchenjane/article/details/53244689