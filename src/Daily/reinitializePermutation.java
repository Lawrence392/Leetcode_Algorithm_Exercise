package Daily;


public class reinitializePermutation {
    public static int Solution(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if((i & 1) == 0){
                arr[i] = i/2;
            }else{
                arr[i] = n/2 + (i -1)/2;
            }
        }
        int count = 0, head = 1;
        while(true){
            head = arr[head];
            count++;
            if(head == 1){
                break;
            }
        }
        return count;
    }
    public static int Solution_2(int n) {
        if (n == 2) {
            return 1;
        }
        int step = 1, pow2 = 2;
        while (pow2 != 1) {
            step++;
            pow2 = pow2 * 2 % (n - 1);
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(Solution(20));
        System.out.println(Solution_2(20));
    }
} 