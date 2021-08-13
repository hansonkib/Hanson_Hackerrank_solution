package Algorithm.SimpleArraySum;

public class ArraySum {
    public int GetSum(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum +=a[i];
        }
        System.out.println(sum);
        return sum;
    }
}
