package Recursion.PowerSum;

import java.util.Scanner;

public class Solution {

    static int count(int sum, int exp, int start) {
        int val = (int) Math.round(Math.pow(start, exp));
        if (val > sum) {
            return 0;
        } else if (val == sum) {
            return 1;
        } else {
            return count(sum - val, exp, start + 1) + count(sum, exp, start + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int exp = scanner.nextInt();
        scanner.close();

        System.out.println(count(sum, exp, 1));
    }
}
