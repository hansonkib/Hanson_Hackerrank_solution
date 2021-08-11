package SearchAgorithms.SherlockArray;


import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        while(cases-->0) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String in[] = br.readLine().split(" ");
            int totalsum = 0;
            for(int i=0;i<n;i++) {
                arr[i] = Integer.parseInt(in[i]);
                totalsum+=arr[i];
            }
            boolean res = false;
            int lsum = 0;
            int rsum = totalsum;
            for(int i=0;i<n;i++) {
                if(i>0) {
                    lsum+=arr[i-1];
                }
                rsum=totalsum-lsum-arr[i];
                if(rsum==lsum){
                    res = true;
                    break;
                }
            }
            if(res) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
