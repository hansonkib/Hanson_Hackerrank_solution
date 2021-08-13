package Algorithm.SimpleArraySum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySumTest {

    @Test
    void arraySum() {
        int[] input = new int[]{1,2,3,4,5,6};
        assertEquals(21,new ArraySum().GetSum(input));
    }
}