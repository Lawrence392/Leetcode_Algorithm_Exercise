package Other;

// https://leetcode.cn/problems/search-in-rotated-sorted-array/
// 整数数组 nums 按升序排列，数组中的值 互不相同 。
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
// 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
// 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1

public class searchII {
    public int searchII1(int[] nums, int target) {
        int left = 0,right = nums.length -1;
        int mid = 0;
        
        int n = (int)nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        
        while(left <= right){
            mid = left + (right - left) /2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] >= nums[0]){ // 判断mid是位于左侧还是右侧子集
                if(nums[mid] >target && target >= nums[0]){ // 目标值不位于左侧子集,则left应该右移
                    right = mid-1; // mid对应值小于了target,left也应该右移
                }else{ 
                    left = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[n-1]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    // 理解:
    // mid将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
    // 如果target存在于有序部分,用二分法查找。
    // 如果target存在于无序部分,再一分为二，其中一个一定有序，另一个可能有序，可能无序
    // 
    public static void main(String[] args) {
        
    }
}
