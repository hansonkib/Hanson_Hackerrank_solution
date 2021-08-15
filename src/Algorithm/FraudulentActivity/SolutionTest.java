package Algorithm.FraudulentActivity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
Solution solution;
    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @AfterEach
    void tearDown() {
        solution=null;
    }

    @Test
    void findFraud() {
        int[] input1 = new int[]{5,4};
        int[] input2 = new int[]{1,2,3,4,4};
        assertEquals(0,solution.findFraud(input1,input2));
    }
}