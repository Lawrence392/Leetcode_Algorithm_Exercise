package Other;
import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {
    public static boolean containsDuplicate1(int[] nums) {
        Set<Integer> myset = new HashSet<Integer>();
        for (Integer num : nums) {
            if (myset.contains(num)) {
                return true;
            }
            myset.add(num);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        // int[] nums = {1,2,3,4,4};
        if(containsDuplicate1(nums)){
            System.out.println("containsDuplicate");
        }
        
        
    }
}
