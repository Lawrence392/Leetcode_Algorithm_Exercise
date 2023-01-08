package Other;
// https://leetcode.cn/leetbook/read/binary-search/xepthr/


public class firstBadVersion {

    public static int firstBadVersion1(int n) {
        int left = 0,right = n;
        int mid = 0;
        while(left < right){
            mid = left + (right - left)/2;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
    public static boolean isBadVersion(int i){
        if(i >= 4){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(firstBadVersion1(9));
    }
}