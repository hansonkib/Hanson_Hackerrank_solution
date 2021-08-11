package Recursion.CrosswordPuzzle;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        //read input
        Scanner in = new Scanner(System.in);
        char [][] p = new char[10][10];
        for(int i=0; i<10; i++){
            p[i] = in.next().toCharArray();

        }
        in.nextLine();
        LinkedList<String> words = new LinkedList<>();
        in.useDelimiter(";");
        while(in.hasNext()){
            words.add(in.next());
        }

        placeWord(0,words,p);
        //place word, goto next, if it doesn't work out, backtrack
        for(char [] c: p)System.out.println(new String(c));
    }

    static boolean placeWord(int i, LinkedList<String> words, char [][] p ){
        if(i == words.size())return true;

        String word = words.get(i);
        char[] wch = word.toCharArray();
        //place horizontal
        for(int r = 0; r < 10; r++){
            //find empty space

            for(int c =0 ; c < 10; c++){
                int empty = 0;
                int c1 = c;
                while(c1 < 10 &&( p[r][c1] == '-' || ( wch.length > c1-c && p[r][c1]==wch[c1-c])) ){empty++;c1++; }
                //for(char [] c2: p)System.out.println(new String(c2));
                // System.out.println();
                if(empty == wch.length){
                    //place word, move to next
                    for(int ptr=0; ptr<empty; ptr++){
                        p[r][c+ptr] = wch[ptr];
                    }

                    //System.out.println(new String(p[r]));
                    boolean b = placeWord(i+1, words, p);

                    if(b )return true;

                    //clear word
                    for(int ptr=0; ptr<empty; ptr++){
                        p[r][c+ptr] ='-';
                    }

                }
            }
        }
        //place vertical
        for(int c = 0; c < 10; c++){
            //find empty space

            for(int r =0 ; r < 10; r++){
                int empty = 0;
                int c1 = r;
                while(c1<10 && (p[c1][c] == '-' || (wch.length > c1 - r && p[c1][c]==wch[c1-r])  ) ){empty++;c1++; }
                if(empty == wch.length){
                    //place word, move to next
                    for(int ptr=0; ptr<empty; ptr++){
                        p[r+ptr][c] = wch[ptr];
                    }
                    boolean b = placeWord(i+1, words, p);

                    if(b )return true;

                    //clear word
                    for(int ptr=0; ptr<empty; ptr++){
                        p[r+ptr][c] ='-';
                    }

                }
            }
        }
        return false;
    }
}
