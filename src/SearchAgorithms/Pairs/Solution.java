package SearchAgorithms.Pairs;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String [] params = sc.nextLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int k = Integer.parseInt(params[1]);

        Set<Integer> integers = new TreeSet<Integer>();
        for (int i =0;i<n;i++) {
            integers.add(sc.nextInt());
        }

        int numPairs = 0;
        for (Integer i : integers) {
            if(integers.contains(i+k)) {
                numPairs++;
            }
        }

        System.out.println(numPairs);
    }

}
