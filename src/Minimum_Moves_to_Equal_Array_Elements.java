/**
 * Created by Alvin on 16/11/12.
 */
public class Minimum_Moves_to_Equal_Array_Elements {
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
