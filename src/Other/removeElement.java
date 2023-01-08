package Other;
// https://leetcode.cn/leetbook/read/array-and-string/cwuyj/

// 一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回 移除后数组的新长度。
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
// 输入：nums = [3,2,2,3], val = 3
// 输出：2, nums = [2,2]

public class removeElement {
    public static int name(int[] nums, int val) {
        int fast = 0, last = 0;
        int len = nums.length;
        while(fast < len){
            if(nums[fast] != val){
                nums[last] = nums[fast];
                last++;
            }
            fast++;
        }
        return last;
    
    }
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(name(nums,3));
    }
}
