package Algorithm.SearchAlgorithms.RadioTransmitter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        Input.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = Input.nextInt(), k = Input.nextInt();
        int[] as = new int[n];
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int x : as) set.add(x);
        for (int i = 0; i < n; i++) set.add(as[i] = Input.nextInt());
        Arrays.sort(as);
        int res = 1;
        int at = set.floor(as[0] + k);
        for (int i = 0; i < n; i++) {
            if (as[i] - at > k) {
                at = set.floor(as[i] + k);
                res++;
            }
        }
        out.println(res);
        out.close();
    }
}
