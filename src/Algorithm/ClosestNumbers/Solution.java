package Algorithm.ClosestNumbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        FileReader fileReader = new FileReader("src\\Algorithm\\ClosestNumbers\\input00.txt"); // input from file
        BufferedReader br = new BufferedReader(fileReader);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println("n"+n);
        String line = br.readLine();
        System.out.println("line"+line);
        String [] splitted = line.split(" ");
        int [] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(splitted[i]);
        }
        System.out.println("splited "+Arrays.toString(a));
        Arrays.sort(a);
//         System.out.println(Arrays.toString(a));
        System.out.println("sorted array"+Arrays.toString(a));
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            int diff = a[i+1] - a[i];
            if (diff < min) {
                min = diff;
            }
        }
        for (int i = 0; i < n-1; i++) {
            int diff = a[i+1] - a[i];
            if (diff == min) {
                System.out.print(a[i] + " " + a[i+1]+" ");
            }
        }

    }
}
