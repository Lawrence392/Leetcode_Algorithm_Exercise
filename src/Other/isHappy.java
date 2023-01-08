package Other;
import java.util.HashSet;

// https://leetcode.cn/leetbook/read/hash-table/xh1k9i/


public class isHappy {
    public static boolean isHappy1(int n) {
        HashSet<Integer> hashSet = new HashSet<Integer>();        
        int r = n;
        while(true){
            
            if(r == 1){
                return true;
            }
            
            if(hashSet.contains(r)){
                return false;
            }
            
            hashSet.add(r);
            r = sumultip(r);
        }
        
    }
    public static int sumultip(int n){
        int res = 0;
        while (n > 0) {
            res += Math.pow(n % 10, 2);
            n /= 10;
        }
        return res;
    }
    public static void main(String[] args) {
        int x = 19;
        if(isHappy1(x)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
