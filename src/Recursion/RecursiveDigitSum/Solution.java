package Recursion.RecursiveDigitSum;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] nums = input.toCharArray();
        long sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i]-'0';
        }
        int k = sc.nextInt();
        //This will be the first super number
        long num = sum * k;
        System.out.println(calculate(num));
    }

    public static long calculate(long p) {
        if (p < 10)
            return p;
        return calculate(superNumber(p));
    }
    public static long  superNumber(long num){
        if(num /10 == 0){
            return num;
        }else{
            return num % 10 + superNumber(num/10);
        }
    }
}
