package com.dsAlgo2023.Algoritm.BackTracking;

public class SudokuSolver {
    public static void main(String[] args) {
         int[][] grid = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
         sudokuSolver(grid);
         for(int i=0;i< grid.length;i++){
             for (int j=0;j< grid.length;j++){
                 System.out.print(grid[i][j]+ "  ");
             }
             System.out.println();
         }

    }

    public static boolean sudokuSolver(int[][] grid){
        int row=0 , column = 0;
        boolean isEmpty = false;
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid.length;j++){
                if(grid[i][j]==0){
                    isEmpty=true;
                    row=i; column=j;
                    break;
                }
            }
            if(isEmpty){
                break;
            }
        }
        if(!isEmpty){
            return true;
        }

        for(int num = 1; num<=9; num++){
            if(isSafe(grid,num, row,column)){
                grid[row][column]=num;

                if(sudokuSolver(grid)){
                    return true;
                }
                grid[row][column]=0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] grid, int num, int row, int column) {
        //check in row
        for(int i=0;i< grid.length;i++)
            if(grid[row][i]==num)
                return false;

        //check in column
        for(int i=0;i< grid.length;i++)
            if (grid[i][column]==num)
                return false;

        //check in cube
        int x= row/3, y= column/3;
        x=x*3; y=y*3;

        for(int i=x;i<x+3;i++)
            for(int j=y;j<y+3;j++)
                if (grid[i][j]==num)
                    return false;

        return true;
    }

}
