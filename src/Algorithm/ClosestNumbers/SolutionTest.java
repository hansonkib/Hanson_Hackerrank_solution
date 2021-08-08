package Algorithm.ClosestNumbers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
class SolutionTest {
Solution solutionOne;
FileReader fileReader;
FileReader fileReader1;
BufferedReader bufferedReader;
BufferedReader bufferedReader1;
    @BeforeEach
    void setUp() throws FileNotFoundException {
        System.out.println("setting it up");
        solutionOne = new Solution();
        fileReader = new FileReader("src\\Algorithm\\ClosestNumbers\\testFiles\\input00.txt");
        fileReader1 = new FileReader("src\\Algorithm\\ClosestNumbers\\testFiles\\output00.txt");
        bufferedReader = new BufferedReader(fileReader);
        bufferedReader1 = new BufferedReader(fileReader1);
    }
    @AfterEach
    void tearDown() throws IOException {
        System.out.println("done testing");
        solutionOne = null;
        fileReader.close();
        fileReader.close();
        bufferedReader.close();
        bufferedReader1.close();
    }

    @Test
    @Timeout(2000)
    void solve() throws IOException {
        System.out.println("running test for solve method");
        int n = Integer.parseInt(bufferedReader.readLine());
        String line = bufferedReader.readLine();
        String[] splited = line.split(" ");
        String outputLines = bufferedReader1.readLine();
        assertEquals(outputLines,solutionOne.solve(n,splited));
    }

}