package Algorithm.CountingSort;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    StringBuilder sb = new StringBuilder();
    public String solve(int n, String[] str){
        List<String> list = new ArrayList<>();
        int[] count=new int[100];
        for(int i=0;i<n;i++){
            count[Integer.parseInt(str[i])]++;
        }
        for(int i=0;i<99;i++){
            list.add(count[i]+" ");
            sb.append(count[i]+" ");
        }
        sb.append(count[99]);
        return sb.toString();
    }
}
