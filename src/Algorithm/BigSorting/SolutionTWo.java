package Algorithm.BigSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SolutionTWo {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] unsorted = new String[n];
        for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
            unsorted[unsorted_i] = in.readLine();
        }
        Arrays.sort(unsorted, new Checker());
        for(String s : unsorted)
            System.out.println(s);
    }
//    static class strcmp implements Comparator<String> {
//
//        @Override
//        public int compare(String o1, String o2) {
//            int l1 = o1.length(), l2 = o2.length();
//            return l1 > l2 ? 1 : (l2 > l1 ? -1 : o1.compareTo(o2));
//        }
//
//    }
}
