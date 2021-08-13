package SearchAgorithms.beautifulQuadribles;

import java.util.Arrays;
import java.util.Scanner;

public class Soution {
    static long buildQuadruples(int[] ar){
        int MAX = 3000;
        int MAX_XOR = 4096;
        int A = ar[0];
        int B= ar[1];
        int C= ar[2];
        int D=ar[3];

        int[] total = new int[MAX + 1];
        for (int a = 1; a <= A; a++) {
            for (int b = a; b <= B; b++) {
                total[b] += 1;
            }
        }

        for (int i = 1; i <= MAX; i++) {
            total[i] += total[i - 1];
        }


        int[][] count = new int[MAX + 1][MAX_XOR + 1];
        for (int a = 1; a <= A; a++) {
            for (int b = a; b <= B; b++) {
                count[b][a ^ b] += 1;
            }
        }
        for (int i = 0; i <= MAX_XOR; i++) {
            for (int b = 1; b <= MAX; b++) {
                count[b][i] += count[b - 1][i];
            }
        }

        long ans = 0;
        for (int c = 1; c <= C; c++) {
            for (int d = c; d <= D; d++) {
                ans += (total[c] - count[c][c ^ d]);
            }
        }

        return ans;


    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int D = in.nextInt();
        int arr[] = {A,B,C,D};
        Arrays.sort(arr);
        System.out.print(buildQuadruples(arr));
    }
}
