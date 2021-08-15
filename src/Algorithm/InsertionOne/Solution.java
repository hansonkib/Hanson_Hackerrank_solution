package Algorithm.InsertionOne;

public class Solution {
    StringBuilder sb = new StringBuilder();
    public String insertionSort(int[] a){
        int n = a.length;
        if (n==1)
        {
            appendToBuilder(a);
            System.out.println(sb);
            return sb.toString();
        }
        int temp = a[n-1];
        int index = n-2;
        while(index>=0 && a[index]>temp)
        {
            a[index+1]=a[index];
            appendToBuilder(a);
            index--;
        }
        a[index+1]=temp;
        appendToBuilder(a);
        System.out.print(sb);
        return sb.toString();
    }

    private void appendToBuilder(int[] a) {
        for(int n: a){
            sb.append(n+" ");
        }
        sb.append("\n");
    }

}
