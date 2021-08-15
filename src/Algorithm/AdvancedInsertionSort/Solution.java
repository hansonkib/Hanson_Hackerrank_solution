package Algorithm.AdvancedInsertionSort;

import java.util.Arrays;

public class Solution {
    public String advanceInsertionSort(int[][] inputArray){
        int[] array = new int[inputArray[0].length];
        int[] array2 = new int[inputArray[1].length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                array[j]=inputArray[0][j];
                array2[j]=inputArray[1][j];
            }
        }
        sb.append(mergeSort(array,0,array.length-1)+"\n").append(mergeSort(array2,0,array2.length-1));
        System.out.println(sb);
        return sb.toString();
    }
    public static long mergeSort(int[] a, int low, int high) {
        if (high <= low)
            return 0;
        int temp;
        long count = 0;
        if (high == low + 1) {
            if (a[low] > a[high]) {
                temp = a[high];
                a[high] = a[low];
                a[low] = temp;
                count++;
            }
            return count;
        }
        int mid = (high + low) / 2;
        count += mergeSort(a, low, mid);
        count += mergeSort(a, mid + 1, high);
        count += merge(a, low, mid, high);
        return count;
    }

    public static long merge(int[] a, int low, int mid, int high) {
        long count = 0;
        for (int i = low, j = mid+1; i <= mid && j <= high;) {
            if (a[i] > a[j]) {
                count += mid - i + 1; //only count the first part, the second part is sorted
                j++;
            }
            else
                i++;
        }
        Arrays.sort(a, low, high+1);
        return count;
    }

}
