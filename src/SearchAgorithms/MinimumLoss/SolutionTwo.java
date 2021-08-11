package SearchAgorithms.MinimumLoss;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SolutionTwo {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        long arr[]=new long[n];
        HashMap<Long,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            arr[i]=s.nextLong();
            map.put(arr[i],i);
        }
        long loss=Long.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=n-1;i>0;i--){
            if(map.get(arr[i])<map.get(arr[i-1])){
                loss=Math.min(loss,arr[i]-arr[i-1]);
            }
        }
        System.out.println(loss);
    }
}
