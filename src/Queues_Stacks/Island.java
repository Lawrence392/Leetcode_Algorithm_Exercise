package Queues_Stacks;

// 752

public class Island {
    public static void main(String[] args) {
        char [][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','0','0'},
            {'1','0','1','1','0'},
            {'1','0','1','1','0'}
        };
        System.out.println(Solution(grid));
        double [] inds = {0.0,1};
        System.out.println(inds[0]);
        System.out.println(inds[1]);
        
        
    }
    public static int Solution(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    turnintozero(grid,i,j);
                }
            }
        }
        return count;
    }


    public static void turnintozero(char[][] grid, int i, int j) {
        if(i == -1 || j == -1 || i == grid.length || j == grid[0].length){
            return;
        }
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            turnintozero(grid,i-1,j);
            turnintozero(grid,i+1,j);
            turnintozero(grid,i,j-1);
            turnintozero(grid,i,j+1);
        }
        return;

    }
        


}