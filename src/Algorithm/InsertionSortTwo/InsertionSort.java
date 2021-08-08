package Algorithm.InsertionSortTwo;

import java.util.Scanner;

public class InsertionSort {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int s=scan.nextInt();
        int ar[]=new int[s];
        boolean check=false;
        for(int i=0;i<s;i++)
        {
            ar[i]=scan.nextInt();
        }
        for(int i=1;i<s;i++)
        {
            int temp=ar[i];
            for(int j=i-1;j>=0 && temp<ar[j];j--)
            {
                ar[j+1]=ar[j];
                ar[j]=temp;
            }
            for(int j=0;j<s;j++)
                System.out.print(ar[j]+" ");
            System.out.println();
        }
    }
}
