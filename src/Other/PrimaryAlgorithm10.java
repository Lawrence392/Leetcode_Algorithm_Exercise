package Other;
public class PrimaryAlgorithm10 {
    public static int[] findDiagonalOrder(int[][] mat) {
        int m =0;
        int n =0;
        int maxm = mat.length - 1;
        int maxn = mat[0].length - 1;
        boolean dir = true; // up
        int[] res = new int[(maxm+1)*(maxn+1)];
        int count = 0;

        while(count < (maxm+1)*(maxn+1) - 1)
        {
            res[count++] = mat[m][n];
            if(dir){
                if(n == maxn){
                    m++;
                    dir = false;
                    continue;
                }else if(m == 0){
                    n++;
                    dir = false;
                    continue;
                }else{
                    m--;
                    n++;
                }
                }else{
                if(m == maxm){
                    n++;
                    dir = true;
                    continue;
                }else if(n == 0){
                    m++;
                    dir = true;
                    continue;
                }else{
                    m++;
                    n--;
                }
            }
        }
        res[count] = mat[maxm][maxn];
    



        return res;
    }
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        // int[][] matrix2 = {{1,2},{3,4}};


        //00,01,10,20,11,02,12,21,22
        int[] res = findDiagonalOrder(matrix1);
        // int[] res = findDiagonalOrder(matrix2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
