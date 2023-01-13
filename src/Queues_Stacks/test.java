package Queues_Stacks;

public class test {

// 检验是否传值

    public static void Solution(int [][] grid, int i, int j) {
        grid[i][j] = 20;
        
    }
    public static void main(String[] args) {
        int [][] grid = {
            {1,1,1,1,0},
            {1,1,1,0,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
        };
        int [][] grid2 = new int[4][4];
        grid2 = grid;
        Solution(grid, 1, 2);
        System.out.println(grid[1][2]);
        System.out.println(grid2[1][2]);
    }
}
