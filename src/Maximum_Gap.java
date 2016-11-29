import java.util.Arrays;

/**
 * Created by Alvin on 16/11/29.
 */
//http://blog.csdn.net/tofu_jelly/article/details/43339305
public class Maximum_Gap {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        int max = 0, min = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > max) max = nums[i];
            if(nums[i] < min) min = nums[i];
        }
        int len = (int) Math.ceil((max - min) / (nums.length -1.0));
        if(nums.length == 2) return  max-min;
        if(max == min) return 0;
        int[] maxArray = new int[nums.length];
        int[] minArray = new int[nums.length];
        Arrays.fill(maxArray,Integer.MIN_VALUE);
        Arrays.fill(minArray,Integer.MAX_VALUE);
        for (int i =0 ; i <nums.length; i++){
            int index = (nums[i]-min) / len;
            maxArray[index] = Math.max(nums[i] , maxArray[index]);
            minArray[index] = Math.min(nums[i], minArray[index]);
        }
        int preMax = min;
        int result = 0;
        for (int i =0 ; i < nums.length ; i++){
            if(maxArray[i] == Integer.MIN_VALUE && minArray[i] == Integer.MAX_VALUE)
                continue;
            result = Math.max(result,minArray[i] - preMax);
            preMax = maxArray[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[]  nums ={15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
        System.out.print(new Maximum_Gap().maximumGap(nums));
    }
}

