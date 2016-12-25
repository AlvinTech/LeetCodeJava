import java.util.Arrays;

/**
 * Created by Alvin on 16/12/24.
 */
public class Single_Number_III {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int a : nums)
            diff ^= a;
        diff &= -diff;
        int[] result = new int[2];
        for(int a : nums){
            if((a & diff) == 0){
                result[0] ^= a;
            }else
                result[1] ^= a;
        }
        return  result;
    }

    public static void main(String[] args) {
        int[]  nums = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(new Single_Number_III().singleNumber(nums)));
    }
}
