import java.util.Arrays;

/**
 * Created by Alvin on 16/12/2.
 */
public class Two_Sum_II {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int i =0,j = numbers.length-1; i< j; ){
           if(numbers[i] + numbers[j] >target){
               j--;
           }else if(numbers[i] + numbers[j] <target){
               i++;
           }else{
               result[0] = i+1;
               result[i] = j+1;
               return result;
           }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers ={1,2,5,7};
        int target = 9;
        System.out.println(Arrays.toString(new Two_Sum_II().twoSum(numbers,target)));
    }
}
