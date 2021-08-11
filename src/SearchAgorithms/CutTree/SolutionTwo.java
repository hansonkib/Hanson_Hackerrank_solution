package SearchAgorithms.CutTree;

import java.util.ArrayList;
import java.util.Scanner;

public class SolutionTwo {
    static class Node {
        int value;
        ArrayList<Node> childs = new ArrayList<Node>();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Node[] arr = new Node[num + 1];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= num; i++) {
            arr[i] = new Node();
            arr[i].value = in.nextInt();
            sum += arr[i].value;
        }
        for (int i = 0; i < num - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            arr[a].childs.add(arr[b]);
            arr[b].childs.add(arr[a]);
        }

        // Make the tree
        Node head = arr[1];
        makeTree(head);
        makeSum(head);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].value == sum) {
                continue;
            }
            int temp = Math.abs(sum - 2 * arr[i].value);
            if (temp < min) {
                min = temp;
            }
        }

        System.out.println(min);

    }

    private static void makeSum(Node head) {
        if (head == null) {
            return;
        }
        for (int i = 0; i < head.childs.size(); i++) {
            Node node = head.childs.get(i);
            makeSum(node);
            head.value += node.value;
        }

    }

    private static void makeTree(Node head) {
        if (head == null) {
            return;
        }
        for (Node node : head.childs) {
            if (node.childs.contains(head)) {
                node.childs.remove(head);
            }
        }
        for (Node node : head.childs) {
            // System.out.println(node.value);
            makeTree(node);
        }

    }
}
