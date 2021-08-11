package Recursion.BowlingPins;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        HashSet<Integer> set;
        for (int t=0; t<T;t++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String state = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            List<Integer> pins = new ArrayList<>();
            pins.add(0);
            pins.add(1);
            pins.add(2);
            for(int i = 3; i <= n; i++){
                set = new HashSet<>();
                for(int j = 1; j <= 2; j++){
                    for(int k = 0; k < ((i - j)/ 2) + 1; k++) {
                        set.add(pins.get(k) ^ pins.get(i - j - k));
                    }
                }
                int l = 0;
                while(set.contains(l)){
                    l++;
                }
                pins.add(l);
            }
            int m = 0;
            String[] items = state.split("X");
            for(String item: items){
                m ^= pins.get(item.length());
            }
            System.out.println(m == 0 ? "LOSE" : "WIN");
        }
        scanner.close();
    }
}
