package Other;
// import java.util.*;
//https://leetcode.cn/leetbook/read/array-and-string/ciekh/

public class PrimaryAlgorithm09 {
    public static void setZeroes(int[][] matrix) {
        // Stack<int[]> stack = new Stack<int[]>();
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {//m*n
        //         if(matrix[i][j] == 0){
        //             stack.push(new int[]{i,j});
        //         }
        //     }
        // }
        
        // int[] zero;
        // while(!stack.isEmpty()){
        //     zero = stack.pop();
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         matrix[zero[0]][j] = 0;
        //     }
        //     for (int i = 0; i < matrix.length; i++) {
        //         matrix[i][zero[1]] = 0;
                
        //     }
        // }


        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row[i]=true;
                    column[j]=true;
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(row[i]||column[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},
        {1,0,1},
        {1,1,1}};
        setZeroes(matrix);
        for (int[] is : matrix) {
            for (int is2 : is) {
                System.out.println(is2);
            }
        }
    }
}
