package Algorithm.QuickSort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
        FileReader fileReaderInput = new FileReader("src\\Algorithm\\QuickSort\\inputTestFile.txt");
        FileReader fileReaderOutput = new FileReader("src\\Algorithm\\QuickSort\\outputTestFile.txt");
        BufferedReader bufferedReaderInput= new BufferedReader(fileReaderInput);
        BufferedReader bufferedReaderOutput= new BufferedReader(fileReaderOutput);
        int n = Integer.parseInt(bufferedReaderInput.readLine());
        String[] inputLine = bufferedReaderInput.readLine().split(" ");
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=Integer.parseInt(inputLine[i]);
        }
        Solution solution = new Solution();
        System.out.println(solution.partition(ar));
    }
    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
