package SearchAgorithms.SimmilarPair;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        T = in.nextInt();

        g = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            g[i] = new ArrayList<Integer>();
        }

        int done[] = new int[n+1];
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            done[b] = 1;
            g[a].add(b);
        }

        int root = -1;
        for (int i = 1; i < done.length; i++) {
            if(done[i] == 0){
                root = i;
                break;
            }
        }

        res = 0;
        tree = new long[6*n];
        dfs(root);
        System.out.println(res);
    }

    static int T;
    static long res;

    private static void dfs(int root) {
//		System.out.println(root);
        int left = root - T;
        int right = root + T;

        long p = read(right) - read(left-1);
//		System.out.println(root);
        res += p;

        update(root, 1);
        for (int i = 0; i < g[root].size(); i++) {
            int next = g[root].get(i);
            dfs(next);
        }

        update(root, -1);
    }

    static ArrayList<Integer> g[];

    static long tree[];

    static long read(int idx){
        long sum = 0;
        while (idx > 0){
            sum += tree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }

    static void update(int idx ,long val){
        while (idx < tree.length){
            tree[idx] += val;
            idx += (idx & -idx);
        }
    }
}
