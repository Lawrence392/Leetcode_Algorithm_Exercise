package Other;

public class removeDuplicates {
    public static int[] nums = {0,1,2,3,3,5,6,7,7};
    public static int[] expectedNums = {0,1,2,3,5,6,7};
// 移除重复的数


    public static int removeDuplicates1(int[] nums) {
        int first = 0;



        for (int i = 0; i < nums.length; i++) {
            if(nums[first] < nums[i]){
                first++;
                nums[first] = nums[i];
            }
        }
        return first+1;
    }
    public static void main(String[] args) {
        int k = removeDuplicates1(nums); // 调用

        int len = expectedNums.length;
        if(k != len){
            System.out.println("Error1!");
        }
        for (int i = 0; i < len; i++) {
            if(nums[i] != expectedNums[i]){
                System.out.println("Error2!");
            }
        }

    }
}
