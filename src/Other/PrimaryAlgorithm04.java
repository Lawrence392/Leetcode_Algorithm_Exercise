package Other;
public class PrimaryAlgorithm04 {

    // hash
    public boolean containsDuplicate(int[] nums) {
        int Length = nums.length;
        if(Length <= 1) {
            return false;
        }

        // 定义 hash 表
        int[] hashArr = new int[Length];
        // 0 比较特殊，定义变量专门记 0
        int count0 = 0;
        // 循环存入 hash 表（除余hash算法）
        for(int i = 0; i < Length; i++) {
            // 记 0
            if(nums[i] == 0) {
                count0++;
                if(count0 > 1) {
                    return true;
                }
                continue;    // 不存入 hash 表，直接进入下一循环
            }
            // 除余
            int yu = nums[i] % Length;
            // 余为负数处理
            if(yu < 0) {
                yu += Length;
            }
            // hash 判断
            while(true) {
                // 判断该位置是否有数
                if(hashArr[yu] == 0) {
                    // 无数则存入
                    hashArr[yu] = nums[i];
                    break;
                } else if (hashArr[yu] == nums[i]) {
                    // 有数且相等
                    return true;
                } else {
                    // 有数且不相等，存入后一位，以此类推
                    yu++;
                    if(yu >= Length) {
                        yu -= Length;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
