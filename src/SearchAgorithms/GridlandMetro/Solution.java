package SearchAgorithms.GridlandMetro;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        long numRows = in.nextInt();
        long numColumns = in.nextInt();
        int numTracks = in.nextInt();
        track[] tracks = new track[numTracks+1];
        for(int i=0; i<numTracks; i++){
            tracks[i] = new track();
            tracks[i].row = in.nextLong();
            tracks[i].col1 = in.nextLong();
            tracks[i].col2 = in.nextLong();
        }

        tracks[numTracks] = new track();
        tracks[numTracks].row = numRows + 1;
        tracks[numTracks].col1 = 1;
        tracks[numTracks].col2 = 1;


        Arrays.sort(tracks);
        long row = 1;
        long col = 0;
        long freeSpace = 0;

        for(track t:tracks){
            if(t.row > row){
                freeSpace += numColumns - col;
                row++;
                col = 0;
            }
            if(t.row > row){
                freeSpace += numColumns * (t.row - row);
                row = t.row;
            }

            if(col < t.col1)
                freeSpace += t.col1 - col - 1;

            if(col < t.col2)
                col = t.col2;
        }


        System.out.println(freeSpace);
    }
}

class track implements Comparable<track>{
    long row;
    long col1;
    long col2;

    @Override public int compareTo(track other){
        if(this.row != other.row)
            return (((int)this.row) - ((int)other.row));
        return (((int)this.col1) - ((int)other.col1));
    }
}
