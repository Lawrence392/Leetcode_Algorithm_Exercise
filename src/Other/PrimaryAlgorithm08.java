package Other;
public class PrimaryAlgorithm08 {
    public static void rotate(int[][] matrix) {
        int temp = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int  tail = 0;
        for (int i = 0; i < matrix.length; i++) {
                tail = matrix.length - 1;
            for (int j = 0; j < tail; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][tail];
                matrix[i][tail] = temp;
                tail--;
            }
        }


    }
    public static void main(String[] args) {
        int[][] matrix = {{5,1,6},
                        {2,4,8},
                        {13,3,6}};
        rotate(matrix);
        for (int[] is : matrix) {
            for (int is2 : is) {
                System.out.println(is2);
                
            }
        }
    }
}
