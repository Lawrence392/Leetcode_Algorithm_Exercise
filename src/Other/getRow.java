package Other;
import java.util.ArrayList;
import java.util.List;

public class getRow {
    public static List<Integer> getRow1(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if(rowIndex == 0){
            res.add(1);
            return res;
        }
        for (int i = 0; i <= rowIndex; i++) {
            res.add(Combination(i,rowIndex));
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


    public static void main(String[] args) {
        List<Integer> res = getRow1(30);
        for (Integer integer : res) {
            System.out.println(integer);
        }

    }
}
