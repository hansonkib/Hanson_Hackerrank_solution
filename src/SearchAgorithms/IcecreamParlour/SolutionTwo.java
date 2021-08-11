package SearchAgorithms.IcecreamParlour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class SolutionTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testcases = br.readLine();
        //first input is noof test cases second
        int tests=Integer.parseInt(testcases);
        for(int i=0;i<tests;i++)
        {
            Vector<Integer> vt= new Vector<Integer>();
            String cost=br.readLine();
            String noofitems=br.readLine();
            int costint=Integer.parseInt(cost);
            int no=Integer.parseInt(noofitems);
            String item=br.readLine();
            String[] items=item.split(" ");
            for(int g=0;g<items.length;g++)
            {
                int k=Integer.parseInt(items[g]);
                vt.add(k);
            }
            int cre=costint;


            int a=0,b=0,indexa=0,indexb=0;
            for(int l=0;l<vt.size();l++)
            {
                boolean flg=false;
                a=vt.get(l);
                indexa=l+1;

                for(int m=l+1;m<vt.size();m++)
                {
                    if(vt.get(m)==cre-a)
                    {
                        b=vt.get(m);
                        indexb=m+1;
                        flg=true;
                        break;
                    }
                }
                if(flg)
                    break;

            }
            System.out.printf("%d %d \n",indexa,indexb);

        }


    }
}
