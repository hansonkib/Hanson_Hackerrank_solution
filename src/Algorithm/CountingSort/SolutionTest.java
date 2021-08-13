package Algorithm.CountingSort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
Solution solutionTwo;
FileReader fileReader,fileReader1;
BufferedReader bufferedReader, bufferedReader1;
    @BeforeEach
    void setUp() throws FileNotFoundException {
        solutionTwo = new Solution();
        fileReader = new FileReader("src\\Algorithm\\CountingSort\\TestFiles\\inputTestFile.txt"); //for reading input test file
        fileReader1 = new FileReader("src\\Algorithm\\CountingSort\\TestFiles\\outputTestFile.txt");//for reading output test file
        bufferedReader = new BufferedReader(fileReader);
        bufferedReader1 = new BufferedReader(fileReader1);
    }

    @AfterEach
    void tearDown() throws IOException {
        solutionTwo = null;
        fileReader.close();
        fileReader1.close();
        bufferedReader1.close();
        bufferedReader.close();
    }

    @Test
    void solve() throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] str = bufferedReader.readLine().split(" ");
        String line = bufferedReader1.readLine();
        assertEquals(line,solutionTwo.solve(n,str));
    }
}