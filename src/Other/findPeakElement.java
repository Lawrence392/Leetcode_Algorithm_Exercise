package Other;
// https://leetcode.cn/leetbook/read/binary-search/xem7js/


public class findPeakElement {
    public static int findPeakElement1(int[] nums) {


        int left = 0,right = nums.length - 1;
        int mid = 0;
        while(left < right){
            mid = left + (right - left) /2;
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else if(nums[mid] > nums[mid + 1]){
                right = mid;
            }else{
                return mid;
            }
        }
        return left;
    }
    

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left < right){
            mid = left + (right - left)/2;
            if(nums[mid] > nums[nums.length - 1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int[] nums =  {7,8,9,0,2,3,4};
        System.out.println(findMin(nums));
    }
}
