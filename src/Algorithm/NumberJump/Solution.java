package Algorithm.NumberJump;

import java.io.*;
import java.util.Scanner;

public class Solution {
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

//            int x1 = Integer.parseInt(firstMultipleInput[0]);
            int x1 = sc.nextInt();

//            int v1 = Integer.parseInt(firstMultipleInput[1]);
            int v1 = sc.nextInt();

//            int x2 = Integer.parseInt(firstMultipleInput[2]);
            int x2 = sc.nextInt();

//            int v2 = Integer.parseInt(firstMultipleInput[3]);
            int v2 = sc.nextInt();

            String result = Result.kangaroo(x1, v1, x2, v2);
            System.out.println(result);

//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
//
//            bufferedReader.close();
//            bufferedWriter.close();
        }
}
