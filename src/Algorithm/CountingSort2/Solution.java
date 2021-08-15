package Algorithm.CountingSort2;

public class Solution {
    public String sort(int n, String[] str){
        StringBuilder sb = new StringBuilder();
        int[] count=new int[n];
        for(int i=0;i<n;i++){
            count[Integer.parseInt(str[i])]++;
        }
        for(int i=0;i<100;i++){
            if(count[i]>0){
                for(int j=count[i];j>0;j--){
                    sb.append(i+" ");
                }
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
}
