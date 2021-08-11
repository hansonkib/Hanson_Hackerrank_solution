package Recursion.RepititiveKsums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static long[] resSet;
    static StringBuilder out = new StringBuilder();

    private static String getOriginalSeries(int numTests) throws IOException {

        for (int t = 0; t < numTests; t++) {
            String line = in.readLine();
            String[] data = line.split(" ");
            int numVals = Integer.parseInt(data[0]);
            int numSum = Integer.parseInt(data[1]);

            line = in.readLine();
            data = line.split(" ");
            long[] kSums = new long[data.length];
            for (int i = 0; i < data.length; i++) {
                kSums[i] = Long.parseLong(data[i]);
            }
            Arrays.sort(kSums);
            if (numVals == 1) {
                out.append(kSums[0] / numSum + "\n");
            } else {
                ArrayList<Long> expList = new ArrayList<>();
                resSet = new long[numVals];
                resSet[0] = kSums[0] / numSum;
                expList.add(kSums[0]);
                resSet[1] = kSums[1] - resSet[0] * (numSum - 1);
                int curVal = 2;
                int currIdx = 1;
                for (int i = curVal; i < numVals; i++) {
                    expList.addAll(getNewExpected(i - 1, resSet[i - 1], numSum - 1));
                    Collections.sort(expList);
                    while (expList.size() > currIdx && expList.get(currIdx) == kSums[currIdx]) {
                        currIdx++;
                    }
                    resSet[i] = kSums[currIdx] - resSet[0] * (numSum - 1);
                }
                createResult(numVals);
            }
        }
        return out.toString();
    }

    private static void createResult(int numVals) {
        for (int i = 0; i < numVals; i++) {
            if (i + 1 < numVals) {
                out.append(resSet[i] + " ");
            } else {
                out.append(resSet[i] + "\n");
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int numTests = Integer.parseInt(in.readLine());
        String result = getOriginalSeries(numTests);
        System.out.println(result);
    }

    private static ArrayList<Long> getNewExpected(int curVal, long curSum, int numElements) {
        ArrayList<Long> adding = new ArrayList<Long>();
        if (curVal == 0) {
            adding.add(curSum + numElements * resSet[0]);
        } else {
            for (int i = 0; i <= numElements; i++) {
                adding.addAll(getNewExpected(curVal - 1, curSum + resSet[curVal] * i, numElements - i));
            }
        }

        return adding;
    }
}
