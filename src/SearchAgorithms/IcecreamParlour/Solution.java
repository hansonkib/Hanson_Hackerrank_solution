package SearchAgorithms.IcecreamParlour;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int k = 0; k < T; k++) {
            int C = scan.nextInt();
            int L = scan.nextInt();
            int[] flav = new int[L];
            for (int i = 0; i < L; i++) {
                flav[i] = scan.nextInt();
            }
            HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
            int i1 = 0, i2 = 0;
            for (int i = 0; i < L; i++) {
                if(hash.containsKey(C - flav[i])) {
                    i2 = i;
                    i1 = hash.get(C - flav[i]).intValue();
                    break;
                }
                else {
                    hash.put(flav[i], i);
                }
            }
            System.out.println((i1+1) + " " + (i2+1));
        }
    }

}