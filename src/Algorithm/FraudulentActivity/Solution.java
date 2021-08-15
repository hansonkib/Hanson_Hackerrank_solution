package Algorithm.FraudulentActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int findFraud(int[] inputArray, int[] inputArray2){
        int n = inputArray[0];
        int d = inputArray[1];
        PriorityQueue<Integer> lower = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> upper = new PriorityQueue<Integer>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i > d - 1) {
                double median;
                if (upper.size() == lower.size()) {
                    median = (upper.peek() + lower.peek()) / 2.0;
                }
                else if (upper.size() > lower.size()) {
                    median = upper.peek();
                }
                else {
                    median = lower.peek();
                }
                if (inputArray2[i] >= median * 2) {
                    count++;
                }
                if (inputArray2[i - d] <= lower.peek()) {
                    lower.remove(inputArray2[i - d]);
                    if (lower.size() + 1 < upper.size()) {
                        lower.add(upper.poll());
                    }
                }
                else {
                    upper.remove(inputArray2[i - d]);
                    if (upper.size() + 1 < lower.size()) {
                        upper.add(lower.poll());
                    }
                }
            }
            if (lower.size() == 0 && upper.size() == 0) {
                lower.add(inputArray2[i]);
            }
            else if (upper.size() == 0) {
                if (inputArray2[i] < lower.peek()) {
                    lower.add(inputArray2[i]);
                    upper.add(lower.poll());
                }
                else {
                    upper.add(inputArray2[i]);
                }
            }
            else if (Math.abs(lower.size() - upper.size()) == 1) {
                if (lower.size() < upper.size()) {
                    if (inputArray2[i] < lower.peek()) {
                        lower.add(inputArray2[i]);
                    }
                    else {
                        upper.add(inputArray2[i]);
                        lower.add(upper.poll());
                    }
                }
                else {
                    if (inputArray2[i] > upper.peek()) {
                        upper.add(inputArray2[i]);
                    }
                    else {
                        lower.add(inputArray2[i]);
                        upper.add(lower.poll());
                    }
                }
            }
            else {
                if (inputArray2[i] < lower.peek()) {
                    lower.add(inputArray2[i]);
                }
                else {
                    upper.add(inputArray2[i]);
                }
            }
        }
        System.out.println(count);
        return count;
    }
}
