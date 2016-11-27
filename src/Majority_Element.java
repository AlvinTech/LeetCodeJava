import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alvin on 16/11/26.
 */
public class Majority_Element {
    public int majorityElement(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        for (int j =0 ; j < nums.length; j++){
            if(map.get(nums[j]) == null){
                map.put(nums[j],1);
            }else{
                int count = map.get(nums[j]);
                if(count == nums.length /2)
                    return nums[j];
                map.put(nums[j],count+1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        System.out.println(new Majority_Element().majorityElement(nums));
    }
}
