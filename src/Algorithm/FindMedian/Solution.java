package Algorithm.FindMedian;

import java.util.Arrays;

public class Solution {
public String solve(int n, String[] s){
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(s[i]);
    }
    Arrays.sort(a);
    StringBuilder stringBuilder = new StringBuilder();
    return stringBuilder.append(a[n/2]).toString();
}
}
