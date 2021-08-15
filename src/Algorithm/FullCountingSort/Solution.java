package Algorithm.FullCountingSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public String countingSort(BufferedReader bf) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        StringBuffer[] map = new StringBuffer[100];
        for(int i = 0; i < 100; i++) {
            map[i] = new StringBuffer();
        }
        for(int i = 0; i < n; i++) {
            StringTokenizer tok = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(tok.nextToken());
            String s = tok.nextToken();
            map[v].append(i < n / 2 ? "-" : s).append(" ");
        }
        for(int i = 0; i < 100; i++) {
            sb.append(map[i]);
        }
        System.out.println(sb);
        return sb.toString();
    }
}
