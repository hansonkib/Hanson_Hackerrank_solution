package SearchAgorithms.RedKnightShortestPath;

import java.util.*;

public class Solution {
    enum Move {
        UL( -1 , -2 ),
        UR( 1 , -2 ),
        R( 2 , 0 ),
        LR( 1 , 2 ),
        LL( -1 , 2 ),
        L( -2 , 0 );

        final int dx, dy;
        Move( int dy , int dx ) {
            this.dx = dx;
            this.dy = dy;
        }


    }
    static class Path {
        final Path tail;
        final Move headMove;
        final int i, j;

        Path( Path tail , Move headMove , int i, int j ) {
            this.tail = tail;
            this.headMove = headMove;
            this.i = i;
            this.j = j;
        }

        Path move( Move move ) {
            return new Path( this , move , i + move.dx , j + move.dy );
        }

        public String toString() {
            String prefix = tail == null ? "" : tail.toString();
            String suffix = headMove == null ? "" : headMove.toString();
            return prefix + " " + suffix;
        }

        public int length() {
            if ( tail == null ) return 0;
            return tail.length() + 1;
        }
    }

    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        Queue<Path> queue = new ArrayDeque<Path>();
        Set<List<Integer>> reached = new HashSet<>();

        queue.add( new Path( null , null , i_start , j_start ) );
        reached.add( Arrays.asList( i_start , j_start ) );

        while (!queue.isEmpty()) {
            Path p = queue.remove();

            for ( Move m : Move.values() ) {
                Path child = p.move( m );
                if ( !reached.add( Arrays.asList( child.i , child.j ) ) ) continue;
                if ( child.i >= n ) continue;
                if ( child.i < 0 ) continue;
                if ( child.j >= n ) continue;
                if ( child.j < 0 ) continue;
                if ( child.i == i_end && child.j == j_end ) {
                    System.out.println( child.length() );
                    System.out.println( child.toString().trim() );
                    return;
                }

                //System.out.println( "add "+child );
                queue.add( child );
            }
        }
        System.out.println( "Impossible" );
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        printShortestPath(n, i_start, j_start, i_end, j_end);
        in.close();
    }
}
