package Other;
import java.util.HashMap;
import java.util.Map;

public class containsNearbyDuplicate {
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k){
                    return true;
                }else{
                    map.put(nums[i], i);
                }
            }else{
                map.put(nums[i], i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,1,1}; 
        int k = 1;
        if(containsNearbyDuplicate1(nums,k)){
            System.out.println("ture");
        }

    }
}
