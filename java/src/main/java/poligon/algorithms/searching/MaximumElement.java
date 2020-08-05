package poligon.algorithms.searching;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/maximum-element/problem
 */
public class MaximumElement {

    private static final String sample = "10\n" +
            "1 97\n" +
            "2\n" +
            "1 20\n" +
            "2\n" +
            "1 26\n" +
            "1 20\n" +
            "2\n" +
            "3\n" +
            "1 91\n" +
            "3";

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(sample);

        PriorityQueue<Integer> sorted = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> stack = Collections.asLifoQueue(new LinkedList<>());

        int n = scanner.nextInt();
        while (n-- > 0) {
            int cmd = scanner.nextInt();
            if (cmd == 1) {
                int x = scanner.nextInt();
                System.out.println("Add: " + x);
                stack.add(x);
                sorted.add(x);
            } else if (cmd == 2) {
                Integer x = stack.remove();
                System.out.println("Del: " + x);
                System.out.println("Del sorted: " + sorted.remove(x));
            } else {
                System.out.printf("Max: %d, all: %s%n", sorted.peek(), sorted);
            }
        }
    }

}
