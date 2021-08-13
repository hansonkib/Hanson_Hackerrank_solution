package Algorithm.CountingSort2;

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
FileReader fileReader,fileReader1;
BufferedReader bufferedReader, bufferedReader1;
    @BeforeEach
    void setUp() throws FileNotFoundException {
        solution = new Solution();
        fileReader = new FileReader("src\\Algorithm\\CountingSort2\\TestFiles\\inputTestFile.txt");
        fileReader1 = new FileReader("src\\Algorithm\\CountingSort2\\TestFiles\\outputTestFile.txt");
        bufferedReader = new BufferedReader(fileReader);
        bufferedReader1 = new BufferedReader(fileReader1);
    }

    @AfterEach
    void tearDown() throws IOException {
        solution= null;
        bufferedReader1.close();
        bufferedReader.close();
        fileReader.close();
        fileReader1.close();
    }

    @Test
    void sort() throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        String line =bufferedReader1.readLine();
        String[] str = bufferedReader.readLine().split(" ");
        assertEquals(line+" ",solution.sort(n,str));
    }
}