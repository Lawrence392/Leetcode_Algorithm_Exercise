package Other;
public class searchRange {
    public static int[] searchRange1(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int mid = 0;
        if(nums.length == 0){
            return new int[]{-1,-1};
        }

        while(left <= right){
            mid = left + (right - left)/2;
            if(target > nums[mid]){
                left = mid  + 1;
            }else if(target <= nums[mid]){
                right = mid - 1;
            }
        }
        if(nums[left] != target){
            return new int[]{-1,-1};
        }
        int leftborder = left;

        left = 0;
        right = nums.length -1;
        while(left <= right){
            mid = left + (right - left)/2;
            if(target >= nums[mid]){
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid - 1;
            }
        }
        int rightborder = right;

        return new int[] {leftborder,rightborder};
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] res = searchRange1(nums,8);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
