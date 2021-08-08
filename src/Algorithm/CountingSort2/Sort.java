package Algorithm.CountingSort2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Sort {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try{
            FileReader fileReader = new FileReader("src\\Algorithm\\CountingSort2\\TestFiles\\input00.txt");
            BufferedReader buf=new BufferedReader(fileReader);
            int n=Integer.parseInt(buf.readLine());
            String[] str=buf.readLine().split(" ");
            Solution solution = new Solution();
            solution.sort(n,str);
//            int[] count=new int[100];
//            for(int i=0;i<n;i++){
//                count[Integer.parseInt(str[i])]++;
//            }
//            for(int i=0;i<100;i++){
//                if(count[i]>0){
//                    for(int j=count[i];j>0;j--){
//                        return i+" ";
//                    }
//                }
//            }
        }catch(Exception e){}
//        return null;
    }
}
