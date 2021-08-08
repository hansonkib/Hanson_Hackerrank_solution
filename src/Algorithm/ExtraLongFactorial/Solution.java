package Algorithm.ExtraLongFactorial;

import java.math.BigInteger;

public class Solution {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        Result.extraLongFactorials(n);
//
//        bufferedReader.close();

        public String extraLongFactorials(int n){
            BigInteger factorial = BigInteger.ONE;
            for (int i=2 ; i<= n; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            String s = String.valueOf(factorial);
            return s;
        }

}
