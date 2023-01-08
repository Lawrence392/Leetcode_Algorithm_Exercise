package Other;
// https://leetcode.cn/problems/binary-search/
// 二分查找
public class searchI {
    public static int search1(int[] nums, int target) {
        int mid = 0, left = 0,right = nums.length-1; 
        while(left < right){
            mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        if(nums[left] == target){
            return left;
        }else{
            return -1;
        }
    }



    public static int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) >>> 1;
            if(nums[mid] < target) {
                left = mid + 1;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5};
        System.out.println(search2(nums,4));
    }
}
