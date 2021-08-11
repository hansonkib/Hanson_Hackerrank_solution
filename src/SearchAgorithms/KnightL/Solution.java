package SearchAgorithms.KnightL;

import java.util.Scanner;

public class Solution {

    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solveKnightMove(n);
    }

    private static void solveKnightMove(int n) {
        int sol[][] = new int[n][n];

        for(int i = 0; i < n - 1; ++i) {
            for(int j = i; j < n - 1; ++j) {
                int[][] cache = new int[n][n];
                moveKnight(0, 0, i + 1, j + 1, cache, 0, n);
                sol[i][j] = cache[n-1][n-1] == 0 ? -1 : cache[n-1][n-1];
            }
        }

        for(int i = 0; i < n - 1; ++i) {
            for(int j = 0; j < i; ++j) {
                sol[i][j] = sol[j][i];
            }
        }

        for(int i = 0; i < n - 1; ++i) {
            for(int j = 0; j < n -1; ++j) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void moveKnight(int x, int y, int a, int b, int[][] board, int pathSum, int n) {
        if(isOutOfBoard(x, y, n)) return;
        if(board[x][y] == 0 || board[x][y] > pathSum) {
            board[x][y] = pathSum;
        } else return;

        moveKnight(x + a, y + b, a, b, board, pathSum + 1, n);
        moveKnight(x + b, y + a, a, b, board, pathSum + 1, n);
        moveKnight(x - a, y - b, a, b, board, pathSum + 1, n);
        moveKnight(x - b, y - a, a, b, board, pathSum + 1, n);
        moveKnight(x + a, y - b, a, b, board, pathSum + 1, n);
        moveKnight(x + b, y - a, a, b, board, pathSum + 1, n);
        moveKnight(x - a, y + b, a, b, board, pathSum + 1, n);
        moveKnight(x - b, y + a, a, b, board, pathSum + 1, n);
    }

    private static boolean isOutOfBoard(int x, int y, int n) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
}
