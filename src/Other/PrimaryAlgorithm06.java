package Other;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PrimaryAlgorithm06 {


    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int head1 = 0;
        int head2 = 0;
        List<Integer> res = new ArrayList<Integer>();

        while(head1 < nums1.length && head2 < nums2.length){
            if(nums1[head1] == nums2[head2]){
                res.add(nums1[head1]); 
                head1++;
                head2++;

            }else if(nums1[head1] > nums2[head2]){
                head2++;
            }else{
                head1++;
            }

        }
        int index = 0;
        int[] renum = new int[res.size()];
        for (int k = 0; k < res.size(); k++) {
            renum[index++] = res.get(k);
        }
        return renum;
    }

    
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = intersect(nums1, nums2);
        // 输出：[2,2]
        for (int i : res) {
            System.out.println(i);
        }




    }
}
