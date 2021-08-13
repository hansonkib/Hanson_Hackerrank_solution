package SearchAgorithms.Taskcheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numTasks = Integer.parseInt(scanner.nextLine());
        List<Table> tables = new ArrayList<Table>();
        Table table = new Table(0, 0);
        tables.add(new Table(0,0));
        for(int i = 0; i < numTasks; ++i){
            String[] task = scanner.nextLine().split(" ");
            int deadline = Integer.parseInt(task[0]);
            int time = Integer.parseInt(task[1]);
            table.deadline = deadline;
            int index = findTable(tables, table);
            Table currentTable = null;
            if(tables.get(index).deadline == deadline){
                currentTable = tables.get(index);
            }else{
                Table prevTable = tables.get(index);
                currentTable = new Table(deadline, prevTable.totalTime);
            }
            currentTable.totalTime += time;
            int loopingIndex = index + 1;
            if(tables.get(index).deadline != deadline){
                tables.add(index + 1, currentTable);
                loopingIndex = index + 2;
            }
            for(int j = loopingIndex; j < tables.size(); ++j){
                tables.get(j).totalTime += time;
            }
            int max = 0;
            for(Table t : tables){
                int overtime = t.totalTime - t.deadline;
                if(overtime > max){
                    max = overtime;
                }
            }
            System.out.println(max);
        }
    }

    //returns index if found index - 1 which is the one index less
    //and size - 1 if it is the last element.
    private static int findTable(List<Table> tables, Table table){
        for(int i = 0; i < tables.size(); ++i){
            if(tables.get(i).deadline == table.deadline){
                return i;
            }
            if(tables.get(i).deadline > table.deadline){
                return i - 1;
            }
        }
        return tables.size() - 1;
    }
}
