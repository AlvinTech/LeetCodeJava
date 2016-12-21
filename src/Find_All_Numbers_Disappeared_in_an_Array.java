import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alvin on 16/12/20.
 */
/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
* */
public class Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value != i + 1 && value != nums[value - 1]) {
                int temp = nums[value - 1];
                nums[value - 1] = nums[i];
                nums[i] = temp;
                i--;
            }
            System.out.println(Arrays.toString(nums));
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(new Find_All_Numbers_Disappeared_in_an_Array().findDisappearedNumbers(nums));
    }
}
