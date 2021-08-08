package Algorithm.RunningTimeOfAlgorithms;

import java.util.Scanner;

public class Solution {
    static void insertionSort(int[] ar) {
        int ret = 0;
        for (int i=1; i<ar.length; i++){
            int tmp = ar[i];
            int j = i-1;
            for (; j>=0; j--)
                if (ar[j]>tmp){
                    ret++;
                    ar[j+1]=ar[j];
                }
                else
                    break;
            ar[j+1] = tmp;


        }
        System.out.println(ret);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
}
