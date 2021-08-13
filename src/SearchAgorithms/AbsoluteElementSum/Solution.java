package SearchAgorithms.AbsoluteElementSum;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        long sum[]=new long[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        Arrays.sort(arr);
        int q=sc.nextInt();
        long brr[]=new long[q];

        int k=0,pos=0;
        sum[0]=arr[0];
        long ans=0;
        for(int i=1;i<n;i++)
            sum[i]+=arr[i]+sum[i-1];
        sc.nextLine();
        for(int i=0;i<q;i++)
            brr[i]=sc.nextInt();

        for(int i=1;i<q;i++)
            brr[i]+=brr[i-1];
        for(int i=0;i<q;i++){
            pos = Arrays.binarySearch(arr,(int)-brr[i]);

            if(pos<0)
                pos = -pos-1;

            if(pos>0)
                ans = (sum[n-1]-sum[pos-1]+brr[i]*(long)(n-pos))-(sum[pos-1]+brr[i]*(long)pos);
            else
                ans = (sum[n-1]+brr[i]*(long)n);
            System.out.println(ans);
        }

    }
}
