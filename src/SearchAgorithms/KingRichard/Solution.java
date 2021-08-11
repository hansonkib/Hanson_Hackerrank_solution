package SearchAgorithms.KingRichard;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //N: size of original square
        int s = scanner.nextInt(); //S: numbers of commands

        long[] a = new long[s+1]; //entered rows
        long[] b = new long[s+1]; //entered columns
        long[] d = new long[s+1]; //entered dimension
        long[] t = new long[s+1]; //T: found smallest entries


        a[0] = 1;
        b[0] = 1;
        d[0] = n-1;
        t[0] = 0;

        //input and find smallest entries
        int orientationNum = 4;
        for (int i = 1; i <= s; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            d[i] = scanner.nextInt();

            if (i % orientationNum == 1) {//TOP

                t[i] = t[i-1] + (a[i]-a[i-1])*n + (b[i]-b[i-1]);
            } else if (i % orientationNum == 2) {//RIGHT
                t[i] = t[i-1]+((b[i-1]+d[i-1])-(b[i]+d[i]))*n+(a[i]-a[i-1]);
            } else if (i % orientationNum == 3) {//BOTTOM
                t[i] = t[i-1]+((a[i-1]+d[i-1])-(a[i]+d[i]))*n+((b[i-1]+d[i-1])-(b[i]+d[i]));
            } else if (i % orientationNum == 0) {//LEFT
                t[i] = t[i-1]+(b[i]-b[i-1])*n+((a[i-1]+d[i-1])-(a[i]+d[i]));
            }
        }

        int l = scanner.nextInt(); //L: number of queries
        long[] w = new long[l];
        for (int i = 0; i < l; i++) {
            w[i] = scanner.nextLong();
            int low = 0;
            int high = s;

            //find position of smallest entry
            while (low != high) {
                int mid = (low+high+1)/2;
                if (w[i] >= t[mid] && w[i] < t[mid]+(d[mid]+1)*n && w[i]%n >= t[mid]%n && w[i]%n <= (t[mid]%n)+d[mid]){
                    low = mid;
                }else{
                    high = mid-1;
                }
            }

            //find position of input number with formula: (i, j) = ((v-T)/N, (v-T)%N)
            long off1 = (w[i]-t[low])/n;
            long off2 = (w[i]-t[low])%n;

            if (low % orientationNum == 0) {//TOP
                System.out.println((a[low]+off1)+" "+(b[low]+off2));
            } else if (low % orientationNum == 1) {//RIGHT
                System.out.println((a[low]+off2)+" "+(b[low]+d[low]-off1));
            } else if (low % orientationNum == 2) {//BOTTOM
                System.out.println((a[low]+d[low]-off1)+" "+(b[low]+d[low]-off2));
            } else if (low % orientationNum == 3) {//LEFT
                System.out.println((a[low]+d[low]-off2)+" "+(b[low]+off1));
            }
        }

        scanner.close();
    }
}
