package Algorithm.FindMedian;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
Solution solution;
FileReader fileReader1, fileReader2;
BufferedReader bufferedReader1, bufferedReader2;
    @BeforeEach
    void setUp() throws FileNotFoundException {
        solution = new Solution();
        fileReader1 = new FileReader("src\\Algorithm\\FindMedian\\TestFiles\\inputTestFile.txt");
        fileReader2 = new FileReader("src\\Algorithm\\FindMedian\\TestFiles\\outputTestFile.txt");
        bufferedReader1 = new BufferedReader(fileReader1);
        bufferedReader2 = new BufferedReader(fileReader2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void solve() throws IOException {
        int n = Integer.parseInt(bufferedReader1.readLine());
        String[] s = bufferedReader1.readLine().split(" ");
        String output = bufferedReader2.readLine();
        Assertions.assertEquals(output,solution.solve(n,s));
    }
}