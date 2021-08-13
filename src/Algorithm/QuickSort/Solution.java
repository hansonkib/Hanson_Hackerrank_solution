package Algorithm.QuickSort;

import java.util.Arrays;

public class Solution {
    static String partition(int[] ar) {
        int p=ar[0];
        int[] copy= Arrays.copyOf(ar, ar.length);
        int c=0;
        for(int i=1;i<ar.length;i++){
            if(copy[i]<=p){
                ar[c]=copy[i];
                c++;
            }
        }
        ar[c]=p;
        c++;
        for(int j=0;j<ar.length;j++){
            if(copy[j]>p){
                ar[c]=copy[j];
                c++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer k : ar){
            stringBuilder.append(k+" ");
        }
        return stringBuilder.toString();
    }
}
