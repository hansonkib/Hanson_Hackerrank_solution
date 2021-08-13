package SearchAgorithms.AbsoluteElementSum;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SolutionTwo {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] a = new int[n];

//        int[][] aa = new int[n][4001];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
//        System.out.println("read");
        long[] sumsOfA = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            sumsOfA[i] = sum;
        }



        int qn = in.nextInt();
        int q;
        int minQ = 0, maxQ = 0, currentQ = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < qn; i++) {
            q = in.nextInt();
            currentQ += q;
            minQ = Math.min(minQ, currentQ);
            maxQ = Math.max(maxQ, currentQ);
            int zerroP = Arrays.binarySearch(a, -currentQ);
            if (zerroP < 0) {
                zerroP =  -zerroP - 2;
            }
            long s;
            zerroP = Math.min(a.length - 1, zerroP);
            if (zerroP < 0) {
                s = sumsOfA[a.length - 1]  + n * (0l + currentQ) ;
            } else {
                long negativeSums = (zerroP + 1l) * currentQ + sumsOfA[zerroP];

                long positiveSums = sumsOfA[a.length - 1] - sumsOfA[zerroP] + (a.length - 1l - zerroP) * currentQ;
                s = -negativeSums + positiveSums;
            }
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }
}
