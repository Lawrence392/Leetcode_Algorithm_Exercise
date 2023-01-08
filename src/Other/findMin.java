package Other;
// https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/submissions/
// nums = [3,4,5,1,2]
// 输出：1
// 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。

public class findMin {
    public static int findMin1(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            }
            else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(findMin1(nums));
        
    }
}
