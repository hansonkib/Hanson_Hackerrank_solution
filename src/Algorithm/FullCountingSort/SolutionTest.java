package Algorithm.FullCountingSort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
Solution solution;
FileReader fileReader,fileReaderOutput;
BufferedReader bufferedReader,bufferedReaderOutput;
    @BeforeEach
    void setUp() throws FileNotFoundException {
        solution = new Solution();
        fileReader = new FileReader("src\\Algorithm\\FullCountingSort\\inputTestFile.txt");
        fileReaderOutput = new FileReader("src\\Algorithm\\FullCountingSort\\outputTestFile.txt");
        bufferedReader = new BufferedReader(fileReader);
        bufferedReaderOutput = new BufferedReader(fileReaderOutput);

    }

    @AfterEach
    void tearDown() throws IOException {
        solution = null;
        fileReader.close();
        bufferedReader.close();
        fileReaderOutput.close();
        bufferedReaderOutput.close();
    }

    @Test
    void countingSort() throws IOException {
        String output = bufferedReaderOutput.readLine();
        assertEquals(output+" ",solution.countingSort(bufferedReader));
    }
}