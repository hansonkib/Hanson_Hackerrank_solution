package SearchAgorithms.Taskcheduling;

public class Table implements Comparable<Table> {
    public Table(int deadline, int totalTime){
        this.deadline = deadline;
        this.totalTime = totalTime;
    }

    public int compareTo(Table table){
        return deadline - table.deadline;
    }

    public String toString(){
        return "Deadline: " + deadline + " Total Time: " + totalTime;
    }

    int deadline;
    int totalTime;
}
