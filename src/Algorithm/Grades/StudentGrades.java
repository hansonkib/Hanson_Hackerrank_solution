package Algorithm.Grades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            int grade = in.nextInt();
            if (grade >= 38) {
                if (grade % 5 >= 3) {
                    grade += 5 - (grade % 5);

                }
            }
            list.add(grade);
        }
        for (Integer i : list){
            System.out.println(i);
        }
    }
}
