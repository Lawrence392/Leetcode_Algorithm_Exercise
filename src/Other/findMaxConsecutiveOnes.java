package Other;

public class findMaxConsecutiveOnes {
    public static int name(int[] nums) {
        int temp = 0,count,res = 0;
        int len = nums.length;
        while(temp < len){
            count = 0;
            while(temp < len && nums[temp] == 1){
                temp++;
                count++;
            }
            temp++;
            if(count > res)
            {
                res = count;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(name(nums));
    }
}
