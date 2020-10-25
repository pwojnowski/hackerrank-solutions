package poligon.java;

import java.util.*;

public class ArraysPart2 {

    private int[] game;
    private int leap;
    private int lastIndex;

    private final Scanner scan;

    public ArraysPart2(Scanner scan) {
        this.scan = scan;
    }

    private boolean canWin() {
        // 0 - path, 1 - obstacle, 2 - visited
        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int pos = queue.remove();
            if (game[pos] == 2) { // skip walking visited paths
                continue;
            }
            game[pos] = 2;
            int posRight = pos + 1;
            int posLeft = pos - 1;
            int leapPos = pos + leap;
            if ((lastIndex < posRight) || (lastIndex < leapPos)) {
                return true;
            }
            if (game[posRight] == 0) { queue.add(posRight); }
            if (game[leapPos] == 0) { queue.add(leapPos); }
            if (0 <= posLeft && game[posLeft] == 0) { queue.add(posLeft); }
        }
        return false;
    }

    public String process() {
        StringBuilder sb = new StringBuilder();
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            lastIndex = n - 1;
            leap = scan.nextInt();

            game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            // System.out.println(canWin() ? "YES" : "NO" );
            sb.append(canWin() ? "YES" : "NO" ).append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArraysPart2 solution = new ArraysPart2(scan);
        solution.process();
        scan.close();
    }
}