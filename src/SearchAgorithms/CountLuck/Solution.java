package SearchAgorithms.CountLuck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static int K;
    public static int rows;
    public static int columns;
    public static Field target;
    public static Field[][] fields;

    public static class Field {
        int row;
        int column;
        char type;
        boolean visited = false;
    }

    public static List<Field> getPossibleMoves(Field current) {
        int row = current.row;
        int column = current.column;

        List<Field> possible = new ArrayList<>();

        if ( row > 0 && fields[row - 1][column].type != 'X' && !fields[row - 1][column].visited )
            possible.add(fields[row - 1][column]);

        if ( row < rows - 1 && fields[row + 1][column].type != 'X' && !fields[row + 1][column].visited )
            possible.add(fields[row + 1][column]);

        if ( column > 0 && fields[row][column - 1].type != 'X' && !fields[row][column - 1].visited)
            possible.add(fields[row][column - 1]);

        if ( column < columns - 1 && fields[row][column + 1].type != 'X' && !fields[row][column + 1].visited)
            possible.add(fields[row][column + 1]);

        return possible;
    }

    public static void move(Field current, int waves) {
        if ( current == target ) {
            if ( K == waves )
                System.out.println("Impressed");
            else
                System.out.println("Oops!");

            return;
        }

        current.visited = true;
        List<Field> possibleMoves = getPossibleMoves(current);
        if ( possibleMoves.size() > 1 )
            waves++;

        for ( Field next : possibleMoves )
            move(next, waves);
    }

    public static void main(String[] args) {
        String line;
        Field start = null;
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());

        while ( T-- > 0 ) {
            line = in.nextLine();
            rows = Integer.parseInt(line.split(" ")[0]);
            columns = Integer.parseInt(line.split(" ")[1]);
            fields = new Field[rows][columns];
            for ( int i = 0; i < rows; i++ ) {
                line = in.nextLine();
                for ( int j = 0; j < columns; j++ ) {
                    Field field = new Field();
                    field.row = i;
                    field.column = j;
                    field.type = line.charAt(j);
                    field.visited = false;
                    fields[i][j] = field;

                    if ( line.charAt(j) == 'M' ) {
                        start = field;
                    } else if ( line.charAt(j) == '*' ) {
                        target = field;
                    }
                }
            }

            K = Integer.parseInt(in.nextLine());
            move(start, 0);
        }
    }
}
