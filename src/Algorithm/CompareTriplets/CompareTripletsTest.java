package Algorithm.CompareTriplets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareTripletsTest {

    @Test
    void compare() {
        int[] a = new int[]{5,6,7};
        int[] b = new int[]{3,6,10};
        String result= "1 1 ";
        assertEquals(result,new CompareTriplets().compare(a,b));
    }
}