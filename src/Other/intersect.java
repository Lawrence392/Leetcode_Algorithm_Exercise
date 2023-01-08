package Other;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class intersect {
    public static int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int n = Math.min(nums1.length, nums2.length);
        int[] res = new int[n];
        int i = 0;
        for(int num2 : nums2) {
            if(map.getOrDefault(num2,0) > 0) {
                res[i++] = num2;
                map.put(num2, map.get(num2) - 1);
            }
        }
        
        return Arrays.copyOf(res,i);    
    }
    public static void main(String[] args) {
        



    }   
}
