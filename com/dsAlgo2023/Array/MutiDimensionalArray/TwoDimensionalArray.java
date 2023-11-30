package com.dsAlgo2023.Array.MutiDimensionalArray;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] arr = new int[5][]; // only mentioning row size is compulsory while declaring array
        int[][] brr = new int[5][10];
        int[][][] crr = new int[5][][];
        int [][] drr = new int[2][];

        for (int[] x : arr) System.out.println(x);

        for (int[] x : brr) System.out.println(x);

        System.out.println("-------arr before initialization-------");
        try {
            for (int[] row : arr) {
                for (int column : row)
                    System.out.print(column);
                System.out.println();
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        System.out.println("-------brr-------");
        for (int[] row : brr) {
            for (int column : row)
                System.out.print(column);
            System.out.println();
        }

        for (int row = 0; row < arr.length; row++) {
            arr[row] = new int[]{10, 20, 30, 40, 50};
        }
        System.out.println("-------arr after initialization-------");
        for (int[] row : arr) {
            for (int column : row)
                System.out.print(column);
            System.out.println();
        }
        System.out.println("-------drr-------");
        drr= new int[][]{{10,11,12,13},{20,30}};
        for (int[] row : drr) {
            for (int column : row)
                System.out.print(column);
            System.out.println();
        }

    }
}
/*

for(int[] row : arr)
row=new int[]{10,20,30,40,50};

In your for-each example you are overwriting the local variable of the loop which does not get saved back into the array. It is similar to in your second loop going:

for (int row=0;row<5;row++) {
            arr[row]=new int[]{10,20,30,40,50};
        }
Check out Understanding for each loop in Java for basically the same issue.
 */