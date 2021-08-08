package Algorithm.ClosestNumbers;

import java.util.Arrays;

public class Solution {
    public String solve(int n, String [] splitted){
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(splitted[i]);
        }
        Arrays.sort(a);
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            int diff = a[i+1] - a[i];
            if (diff < max){
                max = diff;
            }
        }
        for (int i = 0; i < n-1; i++) {
            int diff = a[i+1] - a[i];
            if (diff == max){
                return a[i]+" "+a[i+1];
            }
        }

        return null;
    }
}
