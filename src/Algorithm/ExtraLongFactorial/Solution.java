package Algorithm.ExtraLongFactorial;

import java.math.BigInteger;

public class Solution {

        public String extraLongFactorials(int n){
            BigInteger factorial = BigInteger.ONE;
            for (int i=2 ; i<= n; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            String s = String.valueOf(factorial);
            System.out.println(s);
            return s;
        }

}
