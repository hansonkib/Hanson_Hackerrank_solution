package SearchAgorithms.MinimumLoss;

import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        TreeSet<Long> my = new TreeSet<>();
        long res = Long.MAX_VALUE;
        for(int i=0; i<n; i++){
            long cur = sc.nextLong();
            if(my.contains(cur)){
                res = 0;
                break;
            }
            else{
                Long larger = my.higher(cur);
                if(larger!=null && res>larger-cur){
                    res = larger - cur;
                }
                my.add(cur);
            }
        }
        System.out.println(res);


    }
}
