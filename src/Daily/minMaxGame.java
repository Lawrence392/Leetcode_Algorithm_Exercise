package Daily;


public class minMaxGame {
    public static void main(String[] args) {
        int[] nums = {1,3,5,2,4,8,2,2};
        System.out.println(Solution(nums));
    }



    // 模拟实现
    public static int Solution(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        // 迭代
        int len = nums.length/2;
        while(len != 1){
            len /= 2;
            for (int i = 0; i < len; i++) {
                if(i % 2 == 0){
                    nums[i] = Math.min(nums[2*i], nums[2*i+1]);
                }else{
                    nums[i] = Math.max(nums[2*i], nums[2*i+1]);
                }
            }
        }
        return nums[0];
    }
}
