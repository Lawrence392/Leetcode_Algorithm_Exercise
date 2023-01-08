package QuestionsEasy;
/**
 * matrix_rotation
 */
public class Matrix_rotation {

    public static void main(String[] args) {
        
        // int[][] matrix  = {
        //         {1,2,3},
        //         {4,5,6},
        //         {7,8,9}
        //     };

        int[][] matrix  = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(matrix[1][2]);



        int N = matrix.length;
        int[] tempA = matrix[0]; 
        int temp = 0;
        // Top-bottom exchange
        for (int i = 0; i < N/2; i++) {
            tempA = matrix[i];
            matrix[i] = matrix[N-i-1];
            matrix[N-i-1] = tempA;
            }
        
        // Diagonal exchange
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        for (int i = 0; i < tempA.length; i++) {
            for (int j = 0; j < tempA.length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }
}




