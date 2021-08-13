package SearchAgorithms.GenaPlayingHanoi;

import java.util.Scanner;

public class Solution {

    static int solve(int n, int v) {
        int size = 1;
        for (int i = 0; i < n; i++) {
            size *= 4;
        }
        int[] queue = new int[size + 1];
        int[] distance = new int[size];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = size;
        }
        distance[v] = 0;
        queue[0] = v;
        int s = 1;
        int c = 0;
        while(c < s) {
            int q = queue[c];
            int m = 1;
            int[] usage = new int[4];
            for (int k = 0; k < n; k++) {
                int d = (q / m) % 4;
                if (usage[d] == 0) {
                    usage[d] = 1;
                    for (int d1 = 0; d1 < 4; d1++) {
                        if (usage[d1] == 0) {
                            int w = q - d * m + d1 * m;
                            if (distance[w] == size) {
                                distance[w] = distance[q] + 1;
                                queue[s] = w;
                                s++;
                            }
                            if (w == 0) {
                                return distance[w];
                            }
                        }
                    }
                }
                m *= 4;
            }
            c++;
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[N];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int v = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            v = v * 4 + a[i] - 1;
        }
        System.out.println(solve(N, v));

        scanner.close();
    }
}
