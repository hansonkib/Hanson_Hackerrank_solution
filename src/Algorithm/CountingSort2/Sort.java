package Algorithm.CountingSort2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sort {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try{
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            int n=Integer.parseInt(buf.readLine());
            String[] str=buf.readLine().split(" ");
            int[] count=new int[100];
            for(int i=0;i<n;i++){
                count[Integer.parseInt(str[i])]++;
            }
            for(int i=0;i<100;i++){
                if(count[i]>0){
                    for(int j=count[i];j>0;j--){
                        System.out.print(i+" ");
                    }
                }
            }
        }catch(Exception e){}
    }
}
