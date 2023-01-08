package Other;

// https://leetcode.cn/leetbook/read/array-and-string/c0w4r/




public class minSubArrayLen {
    public static int minSubArrayLen1(int target, int[] nums) {
        int sum = 0;
        int len = nums.length;
        int count = Integer.MAX_VALUE;
        for (int i : nums) {
            sum += i;
        }
        if(sum < target){
            return 0;
        }

        for (int i = 0; i < len; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum >= target){
                    count = (count > j-i+1)? j - i + 1 : count;
                }
            }
            if(sum < target){
                break;
            }
        }
        return count;
    }

    // 滑动窗口解法
    public static int minSubArrayLen2(int target, int[] nums) {
        int quick,slow,sum=0,len = nums.length,ans= len+1;
        quick=slow=0;                               //快慢指针初始化

        for(;quick<len;++quick)
        {
            sum+=nums[quick];                       //读入快指针所走元素
            if(sum>=target)                         //达到目标后进行收缩
            {
                while(true)
                {                                   //慢指针可以往后移动多少
                    if(sum-nums[slow]>=target) sum-=nums[slow++];
                    else break;
                }

                if(quick-slow+1<ans) ans = quick-slow+1;  //更新最小长度
            }
        }

        if(ans<len+1) return ans;               //返回判断是否有达到目标
        else return 0;
    }
    

    public static void main(String[] args) {
        int target = 213;
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(minSubArrayLen2(target, nums));

    }
}
