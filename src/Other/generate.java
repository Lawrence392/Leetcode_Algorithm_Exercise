package Other;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/leetbook/read/array-and-string/cuj3m/
// 输出杨辉三角的前n行
//    1     1
//   1,1    2
//  1,2,1   3
// 1,3,3,1  4
public class generate {
    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> nums = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                nums.add(Combination(j,i));
            }
            res.add(nums);
        }

        
        return res;
    }
    public static int Combination(int m,int n){
        if(n == 0){
            return 1;
        }
        if(m > n/2){
            m = n - m;
        }
        int res = 1;

        for (int i = 1; i <= m; i++) {
            res*= n;
            n--;
            res/=i;
        }
        return res;
    }
    // 递推
    public List<List<Integer>> generate2(int numRows) {
        int r = 2, c;
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(new ArrayList<>());
        result.get(0).add(1);
        if (numRows == 1) {
            return result;
        }
        result.add(new ArrayList<>());
        result.get(1).add(1);
        result.get(1).add(1);
        while (r < numRows) {
            c = 1;
            result.add(new ArrayList<>());
            result.get(r).add(1);
            while (c < r) {
                result.get(r).add(result.get(r - 1).get(c - 1) + result.get(r - 1).get(c));
                c++;
            }
            result.get(r).add(1);
            r++;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Combination(5, 5));
        List<List<Integer>> res = generate1(4);
        for (List<Integer> list : res) {
            for (Integer list2 : list) {
                System.out.println(list2);
            }
        }
    }
}
