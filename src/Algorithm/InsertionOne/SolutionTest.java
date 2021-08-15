package Algorithm.InsertionOne;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
Solution solution;
int[] a;
String output;
    @BeforeEach
    void setUp() {
        solution = new Solution();
        a= new int[]{2,4,6,8,3};
        output = "2 4 6 8 8 \n"+"2 4 6 6 8 \n"+"2 4 4 6 8 \n"+"2 3 4 6 8 \n";
    }

    @AfterEach
    void tearDown() {
        solution = null;
        a = null;
        output = null;
    }

    @Test
    void insertionSort() {
        assertEquals(output, solution.insertionSort(a));
    }
}