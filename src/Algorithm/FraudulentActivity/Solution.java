package Algorithm.FraudulentActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        input = in.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
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
                if (arr[i] >= median * 2) {
                    count++;
                }
                if (arr[i - d] <= lower.peek()) {
                    lower.remove(arr[i - d]);
                    if (lower.size() + 1 < upper.size()) {
                        lower.add(upper.poll());
                    }
                }
                else {
                    upper.remove(arr[i - d]);
                    if (upper.size() + 1 < lower.size()) {
                        upper.add(lower.poll());
                    }
                }
            }
            if (lower.size() == 0 && upper.size() == 0) {
                lower.add(arr[i]);
            }
            else if (upper.size() == 0) {
                if (arr[i] < lower.peek()) {
                    lower.add(arr[i]);
                    upper.add(lower.poll());
                }
                else {
                    upper.add(arr[i]);
                }
            }
            else if (Math.abs(lower.size() - upper.size()) == 1) {
                if (lower.size() < upper.size()) {
                    if (arr[i] < lower.peek()) {
                        lower.add(arr[i]);
                    }
                    else {
                        upper.add(arr[i]);
                        lower.add(upper.poll());
                    }
                }
                else {
                    if (arr[i] > upper.peek()) {
                        upper.add(arr[i]);
                    }
                    else {
                        lower.add(arr[i]);
                        upper.add(lower.poll());
                    }
                }
            }
            else {
                if (arr[i] < lower.peek()) {
                    lower.add(arr[i]);
                }
                else {
                    upper.add(arr[i]);
                }
            }
        }
        System.out.println(count);
    }
}
