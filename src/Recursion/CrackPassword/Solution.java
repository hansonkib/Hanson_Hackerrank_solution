package Recursion.CrackPassword;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static String match (String matchString, String password[], Set<String> noSolution)
    {
        if (noSolution.contains(matchString))
            return null;

        for (int i=0; i < password.length; i++)
        {
            if (matchString.length() < password[i].length())
            {
                continue;
            } else if (matchString.length() == password[i].length())
            {
                if (matchString.equals(password[i]))
                    return password[i];
            } else
            {
                String subString = matchString.substring(0, password[i].length());
                if (subString.equals(password[i]))
                {
                    String restString = matchString.substring(password[i].length());
                    String result = match (restString, password, noSolution);
                    if (result != null)
                        return password[i] + " " + result;
                }
            }
        }

        noSolution.add(matchString);
        return null;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i=0; i < T; i++)
        {
            int N = scanner.nextInt();
            String password[] = new String[N];
            for (int j=0; j < N; j++)
                password[j] = scanner.next();

            String loginAttempt = scanner.next();
            Set<String> noSolution = new HashSet<String>();
            String answer = match (loginAttempt, password, noSolution);
            String output = (answer != null) ? answer : "WRONG PASSWORD";
            System.out.println (output);
        }
    }
}
