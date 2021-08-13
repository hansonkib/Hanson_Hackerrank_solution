package SearchAgorithms.SortedSubsegment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static Scanner std = new Scanner(System.in);

    public static int nI(){
        return std.nextInt();
    }

    public static long nL(){
        return std.nextLong();
    }

    public static String next(){
        return std.next();
    }

    public static String nextL(){
        return std.nextLine();
    }

    public static int[] nA(int n){
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = nI();
        }
        return arr;
    }

    public static long fact(int n){
        if(n==1) return 1;
        return n*fact(n-1);
    }

    public static void printArray(int[] arr, int n ){
        for(int i=0;i<n;i++) System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void printArray2(int[][] arr, int n, int m){
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) System.out.print(arr[i][j]+" "); System.out.println();
    }


    public static void print(String str){
        System.out.print(""+str+" ");
    }

    public static void pln(String str){
        System.out.println(""+str);
    }

    private static int gcd(int number1, int number2) //Finds GCD of 2 numbers.
    {
        if(number2 == 0)
        {
            return number1;
        }
        return gcd(number2, number1%number2);
    }

    public static int dcf(int p, int k){
        int t=0;
        while(t*p<k){
            t++;
        }
        if(t*p==k){
            return t*p;
        }
        else{
            return (t-1)*p;
        }
    }

    public static int pf(int g){
        for(int i=2;i<=(g/2+1);i++){
            if(g%i==0){
                return i;
            }
        }
        return g;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n = nI();
        int q = nI();
        int k = nI();
        int[] arr = nA(n);
        ArrayList<Integer> a1 = new ArrayList<>();
        int[] arr1 = new int[q];
        int[] arr2 = new int[q];
        for(int h=0;h<q;h++){
            arr1[h] = nI();
            arr2[h] = nI();
        }
        int dd = k;
        int ee = k;
        for(int h=q-1;h>=0;h--){
            if(dd<=arr1[h] && ee>=arr2[h]){
                continue;
            }
            if((arr1[h]<=dd && arr2[h]>=dd) || (arr1[h]<=ee && arr2[h]>=ee)){
                if(arr1[h]<dd){
                    dd = arr1[h];
                }
                if(arr2[h]>ee){
                    ee = arr2[h];
                }
                a1.add(h);
            }
        }
        if(dd==0 && ee == n-1){
            Arrays.sort(arr);
        }
        else{
            for(int h=a1.size()-1;h>=0;h--){
                int ff = a1.get(h);
                Arrays.sort(arr, arr1[ff], arr2[ff]+1);
                // printArray(arr,n);
            }
        }
        pln(""+arr[k]);
    }
}
