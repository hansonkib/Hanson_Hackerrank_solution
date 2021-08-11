package Recursion.KFactorization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static void generateSeries(int n,int[] a,ArrayList<Integer> comb,ArrayList<ArrayList<Integer>> res,Long prod){
        if(n==0){
            return ;
        }
        if(n==1)
        {
            // System.out.println(comb);
            res.add(new ArrayList(comb));

            return;
        }
        for(int i=a.length-1;i>=0;i--){
            if(a[i]==1||a[i]==0||n%a[i]!=0)
                continue;
            //prod=prod*a[i];
            comb.add(a[i]);
            //System.out.println(comb[i]);
            generateSeries(n/a[i],a,comb,res,prod);
            if(res.size()==1)
                break;
            //prod/=comb.get(comb.size()-1);
            n*=a[i];
            comb.remove(comb.size()-1);
        }

    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int x=1;
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        Arrays.sort(a);
        ArrayList<Integer> comb=new ArrayList();
        ArrayList<ArrayList<Integer>> res=new ArrayList();
        generateSeries(num,a,comb,res,1l);
        // Collections.sort(res,new SortHelp());
        //  System.out.println(res);
        if(res.isEmpty())
            System.out.println(-1);
        else {
            res.get(0).add(1);
            for(int i=res.get(0).size()-1;i>=0;i--){
                x=x*res.get(0).get(i);
                System.out.print(x+"\t");}}
    }
}
