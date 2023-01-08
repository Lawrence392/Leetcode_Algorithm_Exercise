package Other;
// https://leetcode.cn/problems/sqrtx/
// x 的平方根
// 二分查找


public class mySqrt {
    public static int mySqrt1(int x) {
        int left = 0,right = x;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left)/2;
            if(mid*mid > x){
                right = mid-1;
            }else if(mid*mid < x){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return right;


    }


    public static void main(String[] args) {
        System.out.println(mySqrt1(10));
    }
}
