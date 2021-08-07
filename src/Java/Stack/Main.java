package Java.Stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            Solution solution = new Solution();
            System.out.println(solution.checkIfBalanced(input, '{', '}') && solution.checkIfBalanced(input, '[', ']') && solution.checkIfBalanced(input, '(', ')'));
        }
    }
}
