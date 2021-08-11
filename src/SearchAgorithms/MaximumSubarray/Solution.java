package SearchAgorithms.MaximumSubarray;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static class Z implements Comparable {
        long p;
        int idx;

        public Z(long p, int idx) {
            this.p = p;
            this.idx = idx;
        }

        @Override
        public int compareTo(Object o) {
            long d = this.p - ((Z) o).p;
            return d == 0 ? 0 : d > 0 ? 1 : -1;
        }

        @Override
        public String toString() {
            return "Z{" +
                    "p=" + p +
                    ", idx=" + idx +
                    '}';
        }
    }

    private static long maxSum(long[] arr, long m) {
        long curr = 0, max = 0;
        List<Z> z = new ArrayList<Z>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            curr = (arr[i] % m + curr) % m;
            if (curr > max) {
                max = curr;
            }
            z.add(new Z(curr, i));
        }
        Collections.sort(z);

        long min = Long.MAX_VALUE;
        for (int i = 0; i < z.size() - 1; i++) {
            if (z.get(i).idx > z.get(i + 1).idx) {
                if (z.get(i + 1).p - z.get(i).p < min) {
                    min = z.get(i + 1).p - z.get(i).p;
                }
            }
        }

        return Math.max(max, m - min);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int c = in.nextInt();
            long m = in.nextLong();
            long[] arr = new long[c];

            for (int j = 0; j < c; j++) {
                arr[j] = in.nextInt();
            }
            sb.append(maxSum(arr, m)).append("\n");
        }
        System.out.println(sb);
    }
}
