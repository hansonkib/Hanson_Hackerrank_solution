package SearchAgorithms.ConnectedCells;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionTwo {
    private static int[][] oBoard, tBoard;
    private static int myHeight, myWidth;


    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        myHeight = Integer.parseInt(inp.readLine());
        myWidth  = Integer.parseInt(inp.readLine());
        oBoard = new int[myHeight][myWidth];
        tBoard = new int[myHeight][myWidth];

        String curLine;
        String[] rowCells;
        for (int i=0; i<myHeight; i++) {
            curLine = inp.readLine();
            rowCells = curLine.split(" ");

            for (int j=0; j<myWidth; j++) {
                oBoard[i][j] = Integer.parseInt(rowCells[j]);
            }
        }

        int maxGroup = 0;
        for (int row=0; row<myHeight; row++) {
            for (int col=0; col<myWidth; col++) {
                maxGroup = Math.max(maxGroup, regionSize(row, col));
            }
        }

        System.out.println(maxGroup);
    }

    private static int regionSize(int row, int col) {
        if (   row < 0 || row >= myHeight
                || col < 0 || col >= myWidth ) {
            return 0;
        }

        if (oBoard[row][col] == 0) {
            return 0;
        }

        int ret=1;
        oBoard[row][col] = 0;

        for (int i= -1; i<=1; i++) {
            for (int j= -1; j<=1; j++) {
                ret += regionSize(row+i, col+j);
            }
        }

        return ret;
    }
}
