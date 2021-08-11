package SearchAgorithms.ConnectedCells;

import java.util.Scanner;

public class Solution {
    private static int[][] moves = {
            {-1, -1, -1, 0, 0, 1, 1, 1},
            {-1, 0, 1, -1, 1, -1, 0, 1}
    };

    private static int count(int[][] arr, boolean[][] visited, int r, int c) {
        if (visited[r][c]) {
            return 0;
        }

        visited[r][c] = true;

        if (arr[r][c] == 0) {
            return 0;
        }

        int cnt = 1;
        for(int i=0; i<moves[0].length; i++) {
            int nr = r + moves[0][i];
            int nc = c + moves[1][i];

            if (nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length) {
                cnt += count(arr, visited, nr, nc);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int R = s.nextInt();
        int C = s.nextInt();
        int[][] arr = new int[R][C];

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                arr[i][j] = s.nextInt();
            }
        }

        boolean[][] visited = new boolean[R][C];
        int res = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                int n = count(arr, visited, i, j);
                if (n > res) {
                    res = n;
                }
            }
        }

        System.out.println(res);
    }
}
