package SearchAgorithms.DistantPairs;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[][] points = new int[n][2];
        //for(int a0 = 0; a0 < n; a0++){
        for(int points_i=0; points_i < n; points_i++){
            for(int points_j=0; points_j < 2; points_j++){
                int next = in.nextInt();
                //System.out.println("consumed: " + next);
                points[points_i][points_j] = next;
            }
        }
        //}
        Arrays.sort(points, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        compute(n, c, points);
    }

    public static void compute(int n, int c, int[][] points) {
        int max = -1;
        int explored = 0;
        for (int a = 0; a < points.length; a++) {
            for (int b = points.length - 1; b > a; b--) {
                explored++;
                if (explored > 10000000) { System.out.println(max); return; }
                if (a == b) { continue; }
                int[] pa = points[a];
                int[] pb = points[b];
                int minDist = minDist(pa[0], pa[1], pb[0], pb[1], c);
                if (minDist > max) { max = minDist; }
            }
        }
        System.out.println(max);
    }

    public static int minDist(int ai, int bi, int aj, int bj, int c) {
        List<Integer> mins = new ArrayList<>();
        mins.add(minForPoint(ai, aj, c));
        mins.add(minForPoint(ai, bi, c));
        mins.add(minForPoint(ai, bj, c));
        mins.add(minForPoint(bi, bj, c));
        mins.add(minForPoint(aj, bi, c));
        mins.add(minForPoint(aj, bj, c));
        return (int) Collections.min(mins);
    }

    public static int minForPoint(int a, int b, int c) {
        return Math.min(Math.abs(a - b), c - Math.abs(a - b));
    }
}
