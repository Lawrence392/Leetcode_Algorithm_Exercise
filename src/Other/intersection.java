package Other;
// https://leetcode.cn/problems/intersection-of-two-arrays/solution/
import java.util.HashSet;
import java.util.Set;
public class intersection {
    public static int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (Integer integer : nums1) {
            if(!set1.contains(integer)){
                set1.add(integer);
            }
        }
        
        for (Integer integer : nums2) {
            if(set1.contains(integer)){
                set2.add(integer);
            }
        }
        int[] res = new int[set2.size()];
        int i = 0;
        for (Integer integer : set2) {
            res[i++] = integer;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] res = intersection1(nums1,nums2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}


