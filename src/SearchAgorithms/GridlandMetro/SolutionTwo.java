package SearchAgorithms.GridlandMetro;

import java.util.*;

public class SolutionTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long m = sc.nextInt();
        int k = sc.nextInt();
        long ans = n * m;

        HashMap<Integer, List<Interval>> intervalMap = new HashMap<Integer, List<Interval>>();

        for(int i = 0; i < k; i++)
        {
            int r = sc.nextInt();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();

            if(!intervalMap.containsKey(r))
            {
                intervalMap.put(r, new ArrayList<Interval>());
            }

            intervalMap.get(r).add(new Interval(c1, c2));
        }

        for(Integer key : intervalMap.keySet())
        {
            List<Interval> intervals = intervalMap.get(key);
            Collections.sort(intervals);
            int reduction = 0;
            int begin = intervals.get(0).x;
            int end = intervals.get(0).y;

            for(int i = 1; i < intervals.size(); i++)
            {
                if(intervals.get(i).y > end)
                {
                    if(intervals.get(i).x > end)
                    {
                        reduction += end - begin + 1;
                        begin = intervals.get(i).x;
                        end = intervals.get(i).y;
                    }
                    else
                    {
                        end = intervals.get(i).y;
                    }
                }
            }

            reduction += end - begin + 1;

            ans -= reduction;
        }
        sc.close();
        System.out.println(ans);
    }
}

class Interval implements Comparable<Interval>
{
    int x, y;

    public Interval(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Interval arg0) {
        if(this.x < arg0.x)
        {
            return -1;
        }

        if(this.x > arg0.x)
        {
            return 1;
        }

        return arg0.y - this.y;
    }
}