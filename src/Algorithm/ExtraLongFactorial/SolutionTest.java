package Algorithm.ExtraLongFactorial;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution;
    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void extraLongFactorials() throws IOException {
        FileReader fileReader = new FileReader("src\\Algorithm\\ExtraLongFactorial\\output.txt");
        BufferedReader bf = new BufferedReader(fileReader);
        String line = bf.readLine();
        assertEquals(line,new Solution().extraLongFactorials(25));
    }
}