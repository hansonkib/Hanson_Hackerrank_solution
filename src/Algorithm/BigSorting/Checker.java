package Algorithm.BigSorting;

import java.util.Comparator;

public class Checker implements Comparator<String> {
    @Override
    public int compare(String s, String t1) {
        int len1 = s.length();
        int len2 = t1.length();
        if (len1 > len2){
            return 1;
        }else if (len2>len1){
            return -1;
        }else {
         return s.compareTo(t1);
        }
    }
}
