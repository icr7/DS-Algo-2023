package com.dsAlgo2023.Array;

public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        int [] arr = new int[]{0,2,1,2,0};
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
    }

    public static void swap(int[] a, int x, int y){
        int temp=a[x];
        a[x]=a[y];
        a[y]=temp;
    }
}