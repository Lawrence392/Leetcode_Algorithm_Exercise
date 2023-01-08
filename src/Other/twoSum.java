package Other;
public class twoSum {
    public int[] twoSum1(int[] numbers, int target) {
        int left = 0,right = numbers.length - 1;
        while(left < right){
            while(numbers[left] + numbers[right]  > target){
                right--;
            }
            if(numbers[left] + numbers[right] == target) {
                return new int[] {left, right};
            }
            left++;
        }
        return new int[] {-1, -1};

    
        
        
    }
}
