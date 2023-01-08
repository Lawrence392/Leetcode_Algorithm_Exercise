package Other;
// https://leetcode.cn/problems/single-number/solution/


public class singleNumber{
    public static int singleNumber1(int[] nums) {
        int res = nums[0];
        for(int i= 1; i < nums.length; i++){
            res = nums[i] ^ res;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber1(nums));
        


    }

}