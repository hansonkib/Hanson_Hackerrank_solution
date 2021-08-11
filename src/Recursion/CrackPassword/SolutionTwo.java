package Recursion.CrackPassword;

import java.util.*;

public class SolutionTwo {

    public static List<String> crack(String[] dict, String phrase, String result, String left, List<String> resultList, Map<String, String> memo) {
        if (!memo.containsKey(left)) {
            for (int i = 0; i < dict.length; i++) {
                if (left.startsWith(dict[i])) {
                    crack(
                            dict,
                            phrase,
                            result + " " + dict[i],
                            left.substring(dict[i].length(), left.length()),
                            resultList,
                            memo);
                }
            }

            memo.put(left, result);
        } else {
            result = memo.get(left);
        }

        if (result.replace(" ", "").equals(phrase)) {
            resultList.add(result.trim());
        }

        return resultList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int i = 0; i < tests; i++) {
            String[] dict = new String[sc.nextInt()];
            for (int k = 0; k < dict.length; k++) {
                dict[k] = sc.next();
            }
            String phrase = sc.next();
            List<String> results = crack(dict, phrase, "", phrase, new ArrayList<String>(), new HashMap<String, String>());

            /*
            for (String passwords: results) {
                System.out.println(passwords);
            }
            */

            System.out.println(results.isEmpty() ? "WRONG PASSWORD" : results.get(0));
        }
    }
}
