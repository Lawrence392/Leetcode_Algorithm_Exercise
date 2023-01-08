package Other;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimaryAlgorithm05 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            //因为集合set中不能有重复的元素，如果有重复的
            //元素添加，就会添加失败
            if (!set.add(num))
                return true;
        }
        return false;
    }


    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            if(i == nums.length - 1){
                return nums[i];
            }
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,3,2,1};
        System.out.println(singleNumber(nums)); 
    }
}
