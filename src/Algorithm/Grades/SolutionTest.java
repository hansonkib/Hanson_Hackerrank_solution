package Algorithm.Grades;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();
    @Test
    void solveGrade() {
        List<Integer> inputGrades = new ArrayList<>();
        inputGrades.add(4);
        inputGrades.add(73);
        inputGrades.add(67);
        inputGrades.add(38);
        inputGrades.add(33);
        List<Integer> output = new ArrayList<>();
        output.add(75);
        output.add(67);
        output.add(40);
        output.add(33);
        Assertions.assertEquals(output,solution.solveGrade(inputGrades));


    }
}