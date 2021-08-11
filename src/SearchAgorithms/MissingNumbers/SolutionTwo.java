package SearchAgorithms.MissingNumbers;

import java.util.HashMap;
import java.util.Scanner;

public class SolutionTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int N = in.nextInt();
        int[] A = new int[N];
        HashMap<Integer, Integer> countA = new HashMap<Integer, Integer>(N);
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
            if (!countA.containsKey(A[i])) {
                countA.put(A[i], 0);
            }
            countA.put(A[i], countA.get(A[i]) + 1);
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        int M = in.nextInt();
        int[] B = new int[M];
        HashMap<Integer, Integer> countB = new HashMap<Integer, Integer>(M);
        for (int i = 0; i < M; i++) {
            B[i] = in.nextInt();
            if (!countB.containsKey(B[i])) {
                countB.put(B[i], 0);
            }
            countB.put(B[i], countB.get(B[i]) + 1);
            max = Math.max(max, B[i]);
            min = Math.min(min, B[i]);
        }
        for (int i = min; i <= max; i++) {
            if (countA.get(i)< countB.get(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
