package com.dsAlgo2023.Algoritm.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int board[][] = new int[4][4];
        nQueens(board,0);
        printBoard(board);

        board = new int[4][4];
        List<int[][]>boards = new ArrayList<>();
        nQueensAll(board,0, boards);
        System.out.println("\nPrint All possible boards which bring solution");
        boards.forEach(b->printBoard(b));
    }


    private static boolean nQueensAll(int[][] board, int row, List<int[][]> boards) {
        if(row>=board.length)
            return true;

        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]=1;
                if(nQueensAll(board,row+1,boards))
                    boards.add(copyBoard(board));
                board[row][col]=0;
            }
        }
        return false;
    }

    private static int[][] copyBoard(int[][] board) {
        int[][] boardCopy= new int [board.length][board.length];
        for (int i =0;i< board.length;i++)
            for (int j=0;j<board[i].length;j++)
                boardCopy[i][j]=board[i][j];
        return boardCopy;
    }


    public static boolean nQueens(int[][] board, int row){
        if(row>=board.length)
            return true;

        for(int col=0; col<board.length; col++){
            if(isSafe(board,row,col)){
                board[row][col]=1;
                if(nQueens(board,row+1)) //jab mera board pura fill ho jaye means mereko ek solution mil jaye tab true hoga
                    return true;// ye true kar k purane saarey recursion bhi true ho jayengay aur ye loop se bhar nikar jayega  but iss se hmko ek he soluntion milega
                board[row][col]=0;// jab koi safe nhi hoga next row m by putting queen at board[row][col] tab ham queen ko hata dengay aur next column m move kar dengay
            }
        }
        return false; // ye false tab hoga jab koi bhi safe hni hoga row mai
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

    private static void printBoard(int[][] board) {
        System.out.println();
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board.length;j++)
                System.out.print(board[i][j]+" ");
            System.out.print("\n");
        }
    }
}
