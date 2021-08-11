package SearchAgorithms.Pairs;

import java.util.HashSet;
import java.util.Scanner;

public class SolutionTwo {
    public static void main(String [] Args){
        Scanner s;
        s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();

        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < N; i++){
            set.add(s.nextInt());
        }

        int answer = 0;

        for(Integer i : set){
            if(set.contains(i + K))
                answer++;
        }

        System.out.println(answer);

    }
}
