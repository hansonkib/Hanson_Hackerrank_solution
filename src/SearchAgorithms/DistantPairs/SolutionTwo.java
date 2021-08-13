package SearchAgorithms.DistantPairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class SolutionTwo {

    static Pair[] pairs;
    static int n, c;

    static class Pair{
        int a;
        int b;
        int length;

        Pair(int a, int b){
            this.a = Math.min(a, b);
            this.b = Math.max(a, b);
            length = Math.min(this.b-this.a, c - (this.b-this.a));
        }
    }

    static class SegmentTree {

        int n;
        int[] t;

        SegmentTree(int n) {
            this.n = n;
            t = new int[4 * n];
        }

        void build(int a[], int v, int tl, int tr) {
            if (tl == tr) {
                t[v] = a[tl];
            } else {
                int tm = (tl + tr) / 2;
                build(a, v * 2, tl, tm);
                build(a, v * 2 + 1, tm + 1, tr);
                t[v] = Math.max(t[v * 2], t[v * 2 + 1]);
            }
        }

        void update(int v, int tl, int tr, int pos, int newVal) {
            if (tl == tr) {
                t[v] = newVal;
            } else {
                int tm = (tl + tr) / 2;
                if (pos <= tm) {
                    update(v*2, tl, tm, pos, newVal);
                }else {
                    update(v*2+1, tm+1, tr, pos, newVal);
                }
                t[v] = Math.max(t[v * 2], t[v * 2 + 1]);
            }
        }

        int query(int v, int tl, int tr, int l, int r) {
            if (l > r) {
                return Integer.MIN_VALUE;
            }
            if (l <= tl && tr <= r) {
                return t[v];
            }
            int tm = (tl + tr) / 2;
            return Math.max(query(v * 2, tl, tm, l, Math.min(r, tm)),
                    query(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r));
        }
    }


    static boolean existDistP(int d) {
        int ptr = 0;
        SegmentTree st = new SegmentTree(c);
        for(int i = 0;i < n;i++) {
            Pair p = pairs[i];
            if(p.length < d) {
                continue;
            }
            while(p.a >= pairs[ptr].a+d) {
                Pair p2 = pairs[ptr];
                if(p2.length >= d) {
                    st.update(1, 0, c-1, p2.b, p2.a+1);
                }
                ptr++;
            }

            int ma = st.query(1, 0, c-1, Math.max(0,p.b+d-c), p.a-d);
            ma=Math.max(ma, st.query(1, 0, c-1, p.a+d, p.b-d));
            ma=Math.max(ma, st.query(1, 0, c-1, p.b+d, Math.min(c,p.a-d+c)));
            if(ma>=1 && ma-1+c >= p.b+d) {
                return true;
            }
        }
        return false;
    }

    static int distantPairs() {
        Arrays.sort(pairs, new Comparator<Pair>() {

            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.a-o2.a;
            }});
        int ret=0;
        for(int i=20;i>=0;i--) {
            if(existDistP(ret+(1<<i))) {
                ret+=1<<i;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 2 * 4096 * 4096);
        String[] nc = reader.readLine().trim().split(" ");
        n = Integer.parseInt(nc[0]);
        c = Integer.parseInt(nc[1]);
        pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            String[] pointsRowItems = reader.readLine().trim().split(" ");
            int a = Integer.parseInt(pointsRowItems[0]);
            int b = Integer.parseInt(pointsRowItems[1]);
            pairs[i] = new Pair(a, b);
        }
        int result = distantPairs();
        System.out.println(result);
        reader.close();
    }
}
