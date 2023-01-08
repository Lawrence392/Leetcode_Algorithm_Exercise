package Other;
public class PrimaryAlgorithm03 {
    public static void rotate(int[] nums, int k) {
        // method 1
        // int len = nums.length;
        // int[] newnums = new int[len];
        // for (int i = 0; i < len; i++) {
        //     newnums[i] = nums[ ((len + i) - (k  % len)) % len];
        // }
        // for (int i = 0; i < len; i++) {
        //     nums[i] = newnums[i];
        // }

        // method 2
        // int head = 0;
        // int len = nums.length;
        // int tail = len - 1;
        // int temp = 0;
        // while(head < tail){

        //     temp = nums[head];
        //     nums[head] = nums[tail];
        //     nums[tail] = temp;
        //     head++;
        //     tail--;

        // }
        // head = 0;
        // tail = k % len - 1;
        // while (head < tail) {

        //     temp = nums[head];
        //     nums[head] = nums[tail];
        //     nums[tail] = temp;
        //     head++;
        //     tail--;
        // }
        // head = k  % len;
        // tail = len - 1;
        // while (head < tail) {
        //     temp = nums[head];
        //     nums[head] = nums[tail];
        //     nums[tail] = temp;
        //     head++;
        //     tail--;
        // }

        // //method 2
        // k %= nums.length;
        // int[] rightpart = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        // System.arraycopy(nums, 0, nums, k, nums.length - k);
        // System.arraycopy(rightpart, 0, nums, 0, k);

        


    }
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        int[] res = {5,6,7,1,2,3,4};
        int k = 3;
        
        
        rotate(nums , k);




        for (int i = 0; i < res.length; i++) {
            if(nums[i] != res[i]){
                System.out.println("Error!");
            }
        }
    }
}




