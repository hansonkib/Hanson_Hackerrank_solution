package Algorithm.Grades;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> solveGrade(List<Integer> grd){
        List<Integer> grades = new ArrayList<>();
        int grade;
        int grade1=0;
        for (Integer k : grd){
            for(int a0 = 0; a0 < grd.size(); a0++){
                grade = k;
                grade1=grd.get(grd.indexOf(k));
                if (grade >= 38) {
                    if (grade % 5 >= 3) {
                       grade1= grade +(5 - (grade % 5));

                    }
                }
            }
            grades.add(grade1);
        }
        for (Integer g : grades){
            System.out.println(g);
        }
        return grades;
    }
}
