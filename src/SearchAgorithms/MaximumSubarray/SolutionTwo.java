package SearchAgorithms.MaximumSubarray;

import java.util.Scanner;
import java.util.TreeMap;

public class SolutionTwo {
    public static void doWork(Scanner in){
        int N = in.nextInt();
        long M = in.nextLong();
        long sum=0, max=0;
        TreeMap<Long, Long> tree= new TreeMap<Long, Long>();
        for (int i = 0; i < N; i++) {
            long l = in.nextLong();
            sum = (sum+l)%M;
            if(max<sum){
                max=sum;
            }
            Long b = tree.ceilingKey(sum+1);
            if( b!=null){
                long dif = sum - b + M;
                if( max<dif){
                    max = dif;
                }
            }
            tree.put(sum, sum);
        }
        System.out.println( max );
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            doWork(in);
        }
    }
}
