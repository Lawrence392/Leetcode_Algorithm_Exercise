package Other;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PrimaryAlgorithm07 {
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(target <= nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> {return a[0]-b[0];});

        List<int[]> list = new ArrayList<int[]>();
        int term[] =intervals[0];//临时空间，1 判断是否需要合并集合，2 是否放入结果集
        for (int i = 1; i < intervals.length; i++) {
            if (term[1]>=intervals[i][0]){
                term[1]=Math.max(term[1],intervals[i][1]);
            }else {
                list.add(term);
                term=intervals[i];
            }
        }
        list.add(term);
        return list.toArray(new int[list.size()][2]);
    }
    public static void main(String[] args) {
        // int[] nums = {0,1,0,3,12,2};
        // moveZeroes(nums);
        // for (int i : nums) {
        //     System.out.println(i);
        // }


        // int[] nums = {0,1,2,4,5};
        // System.out.println(searchInsert(nums,6)); 
        // System.out.println(searchInsert(nums,3)); 
        
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] newintervals = merge(intervals);

        for (int[] is : newintervals) {
            for (int is2 : is) {
                System.out.println(is2);
            }
        }



    }

}
