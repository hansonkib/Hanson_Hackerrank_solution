package Algorithm.MagicSquare;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public void solve(ArrayList<int[][]> val, int s[][]){
        int res=Integer.MAX_VALUE;
        for(int[][] x:val){
            res=Math.min(res, diff(x, s));
        }
        System.out.println(res);
    }
    public static int diff(int[][] s1,int[][] s2){
        int d=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                d+=Math.abs(s1[i][j]-s2[i][j]);
        return d;
    }
}
