package com.dsAlgo2023.Algoritm.BackTracking;

public class NQueens {
    public static void main(String[] args) {
        int board[][] = new int[4][4];
        nQueens(board,0);
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board.length;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.print("\n");
        }

    }

    public static boolean nQueens(int[][] board, int row){
        if(row>=board.length)
            return true;

        for(int col=0; col<board.length; col++){
            if(isSafe(board,row,col)){
                board[row][col]=1;
                if(nQueens(board,row+1))
                    return true;
                board[row][col]=0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col){
        int i, j;
        //check upward rows
        for(i=0;i<row;i++)
            if(board[i][col]==1) return false;

        //check left upward diagonal
        for(i=row,j=col;i>=0&j>=0;i--,j--)
            if(board[i][j]==1) return false;

        //check right upward diagonal
        for (i=row,j=col;i>=0&j<board.length;i--,j++)
            if(board[i][j]==1) return  false;

        return true;
    }
}
