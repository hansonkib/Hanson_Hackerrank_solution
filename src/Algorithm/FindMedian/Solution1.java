package Algorithm.FindMedian;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader1 = new FileReader("src\\Algorithm\\FindMedian\\TestFiles\\test.txt");
        BufferedReader bf = new BufferedReader(fileReader1);
        String data = null;
        int numOfLines =0;
        do {
            data = bf.readLine();
            if (data != null){
                numOfLines++;
            }
        }
        while (data != null);
        System.out.println(numOfLines);
        bf.close();
        fileReader1.close();
        fileReader1 =new FileReader("src\\Algorithm\\FindMedian\\TestFiles\\test.txt");
        bf = new BufferedReader(fileReader1);
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append();
        for (int i = 0; i < numOfLines; i++) {
            String s = bf.readLine();
            stringBuilder.append(s).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
