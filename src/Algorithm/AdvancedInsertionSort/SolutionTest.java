package Algorithm.AdvancedInsertionSort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
Solution sort;
    @BeforeEach
    void setUp() {
        sort = new Solution();
    }

    @AfterEach
    void tearDown() {
        sort = null;
    }

    @Test
    void advanceInsertionSort() {
        int[][] inputArray = new int[][]{{1,1,1,2,2},{2,1,3,1,2}};
        assertEquals("0"+"\n"+"4",sort.advanceInsertionSort(inputArray));
    }
}