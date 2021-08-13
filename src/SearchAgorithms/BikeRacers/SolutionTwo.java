package SearchAgorithms.BikeRacers;

import java.util.*;

public class SolutionTwo {
    static class Graph {
        List<Integer>[] g;
        boolean [] visited;
        Graph(List<Integer>[] g) {
            this.g = g;
            visited = new boolean[g.length];
        }
        private void dfs(int node, int[] previous) {
            if (visited[node]) return;
            visited[node] = true;
            for (int i : g[node]) {
                if (!visited[i]) {
                    previous[i] = node;
                    dfs(i, previous);
                }
            }
        }

        public int maxFlow(int source, int sink) {
            int flow = 0;
            int[] previous = new int[g.length];
            while (true) {
                for (int i = 0; i < g.length; i++) visited[i] = false;
                previous[source] = source;
                dfs(source, previous);
                if (!visited[sink]) break;
                flow++;
                int node = sink;
                while (node != source) {
                    removeFromList(g[previous[node]], node);
                    g[node].add(previous[node]);
                    node = previous[node];
                }
            }
            return flow;
        }
    }

    public static void removeFromList(List<Integer> list, int val) {
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) == val)
                list.remove(i);
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public long distanceTo(Pair p) {
            long distance = 0;
            distance += ((long)x-p.x)*((long)x-p.x);
            distance += ((long)y-p.y)*((long)y-p.y);
            return distance;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();
        List<Pair> bikers = new LinkedList<Pair>();
        for (int i = 0; i < N; i++) bikers.add(new Pair(in.nextInt(), in.nextInt()));
        List<Pair> bikes = new LinkedList<Pair>();
        for (int i = 0; i < M; i++) bikes.add(new Pair(in.nextInt(), in.nextInt()));
        long[][] d = new long[N][M];
        List<Long> distances = new ArrayList<Long>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                d[i][j] = bikers.get(i).distanceTo(bikes.get(j));
                distances.add(d[i][j]);
            }
        }
        Collections.sort(distances);
        List<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[N+M+2];
        int from = 0;
        int to = distances.size()-1;
        while (from < to) {
            long distance = distances.get((from+to)/2);
            if (isSolvable(g, d, distance, N, M, K)) to = (from+to)/2;
            else from = (from+to)/2+1;
        }
        System.out.println(distances.get(to));
    }

    public static boolean isSolvable(List<Integer>[] g, long[][] d, long distance, int N, int M, int K) {
        for (int i = 0; i < N+M+2; i++) g[i] = new ArrayList<Integer>();
        for (int i = 0; i <= N; i++) g[0].add(i);
        for (int i = N+1; i < N + M + 1; i++) g[i].add(N+M+1);
        for (int i = 1; i <= N; i++) {
            for (int j = N+1; j < N + M + 1; j++) {
                if (d[i-1][j-N-1] <= distance)  g[i].add(j);
            }
        }
        Graph graph = new Graph(g);
        return (graph.maxFlow(0, N+M+1) >= K);
    }
}
