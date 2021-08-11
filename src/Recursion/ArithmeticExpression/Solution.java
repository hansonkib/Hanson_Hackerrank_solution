package Recursion.ArithmeticExpression;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);

        int size=scan.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<size;i++)
            list.add(scan.nextInt());

        check(0,list.get(0)+"",list,list.get(0));
    }
    public static void check(int index,String exp,ArrayList<Integer> list,long curVal)
    {
        if(index==list.size()-1)
        {
            if(curVal%101==0)
            {
                System.out.println(exp);
                System.exit(0);
            }

        }
        else
        {
            if(index+1<list.size() && list.get(index+1)==1)
            {
                check(index+1,exp+"*"+list.get(index+1),list,curVal*list.get(index+1));
                check(index+1,exp+"+"+list.get(index+1),list,curVal+list.get(index+1));
                check(index+1,exp+"-"+list.get(index+1),list,curVal-list.get(index+1));
            }
            else if(index+1<list.size())
            {
                check(index+1,exp+"+"+list.get(index+1),list,curVal+list.get(index+1));
                check(index+1,exp+"-"+list.get(index+1),list,curVal-list.get(index+1));
                check(index+1,exp+"*"+list.get(index+1),list,curVal*list.get(index+1));
            }
        }
    }
}
