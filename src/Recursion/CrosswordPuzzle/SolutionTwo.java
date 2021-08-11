package Recursion.CrosswordPuzzle;


import java.util.Arrays;
import java.util.Scanner;

public class SolutionTwo {

    private static StringBuilder[] finalCrossword = new StringBuilder[10];

    public static void setCrossword(StringBuilder[] crossword, String[] words) {

        if (words.length == 0){

            finalCrossword = Arrays.copyOf(crossword, crossword.length);
            for (int m = 0; m < crossword.length; m++){
                StringBuilder newStr = new StringBuilder(crossword[m]);
                finalCrossword[m] = newStr;
            }
            return;
        }

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (crossword[i].charAt(j) != '+'){
                    for (int k = 0; k < words.length; k++){
                        StringBuilder[] crosswordCopy_horiz = Arrays.copyOf(crossword, crossword.length);
                        for (int m = 0; m < crossword.length; m++){
                            StringBuilder newStr = new StringBuilder(crossword[m]);
                            crosswordCopy_horiz[m] = newStr;
                        }
                        boolean isRecReq = true;
                        for (int m = 0; m < words[k].length(); m++){
                            if (j + m < 10 && (crosswordCopy_horiz[i].charAt(j + m) == '-' || crosswordCopy_horiz[i].charAt(j + m) == words[k].charAt(m))){
                                if (crosswordCopy_horiz[i].charAt(j + m) == '-'){
                                    crosswordCopy_horiz[i].setCharAt(j + m, words[k].charAt(m));
                                }
                            }
                            else {
                                isRecReq = false;
                                break;
                            }
                        }

                        if (isRecReq){
                            String[] wordsCopy = new String[words.length - 1];
                            int ind = 0;
                            for (int m = 0; m < words.length; m++){
                                if (m != k){
                                    wordsCopy[ind] = words[m];
                                    ind++;
                                }
                            }
                            setCrossword(crosswordCopy_horiz, wordsCopy);
                        }

                        isRecReq = true;

                        StringBuilder[] crosswordCopy_vertic = Arrays.copyOf(crossword, crossword.length);
                        for (int m = 0; m < crossword.length; m++){
                            StringBuilder newStr = new StringBuilder(crossword[m]);
                            crosswordCopy_vertic[m] = newStr;
                        }
                        for (int m = 0; m < words[k].length(); m++){
                            if (i + m < 10 && (crosswordCopy_vertic[i + m].charAt(j) == '-' || crosswordCopy_vertic[i + m].charAt(j) == words[k].charAt(m))){
                                if (crosswordCopy_vertic[i + m].charAt(j) == '-'){
                                    crosswordCopy_vertic[i + m].setCharAt(j, words[k].charAt(m));
                                }
                            }
                            else {
                                isRecReq = false;
                                break;
                            }
                        }

                        if (isRecReq){
                            String[] wordsCopy = new String[words.length - 1];
                            int ind = 0;
                            for (int m = 0; m < words.length; m++){
                                if (m != k){
                                    wordsCopy[ind] = words[m];
                                    ind++;
                                }
                            }
                            setCrossword(crosswordCopy_vertic, wordsCopy);
                        }
                    }
                }
            }
        }

        return;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder[] crossword = new StringBuilder[10];

        for (int i = 0; i < 10; i++){
            crossword[i] = new StringBuilder(in.nextLine());
        }

        String[] words = in.nextLine().split(";");

        setCrossword(crossword, words);

        for (int i = 0; i < 10; i++){
            System.out.println(finalCrossword[i]);
        }
    }
}
