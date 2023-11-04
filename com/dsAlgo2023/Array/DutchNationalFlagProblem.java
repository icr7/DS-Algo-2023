package com.dsAlgo2023.Array;

public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        int [] arr = new int[]{0,2,1,1,0,0,2,1};
        DutchNationalFlagSolution.sort012(arr, arr.length);
        for(int a: arr) System.out.print(a+", ");
    }
}
class DutchNationalFlagSolution
{
    public static void sort012(int[] a, int n)
    {
        int i=0,j=0,k=n-1;
        while(i<=k){
            if(a[i]==0) swap(a,i++,j++);
            else if(a[i]==1) i++;
            else if(a[i]==2) swap(a,i,k--);
        }
        System.out.print("0's -> from index 0 to j-1 : ");print(a, 0, j-1);
        System.out.print("1's -> from index j to k : ");print(a, j, k);
        System.out.print("2's -> from index i to n-1 : ");print(a, i, n-1);

    }

    private static void print(int[] a, int x, int y) {
        for (int i=x;i<=y;i++)
            System.out.print(a[i]+", ");
        System.out.print("\n");
    }

    public static void swap(int[] a, int x, int y){
        int temp=a[x];
        a[x]=a[y];
        a[y]=temp;
    }
}