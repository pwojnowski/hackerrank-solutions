package poligon.algorithms.searching;

public class FirstLastX {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
//        int[] numbers = {1, 1, 1, 1, 1, 1, 1, 1, 1};

        int x = 3;
        int[] result = findFirstLast(numbers, x);
        if (result != null) {
            System.out.printf("%d is between: %d, %d%n", x, result[0], result[1]);
        } else {
            System.out.println(x + " not found.");
        }
    }

    private static int[] findFirstLast(int[] numbers, int x) {
        int from = lowerBound(x, numbers, 0, numbers.length);
        int to = lowerBound(x + 1, numbers, 0, numbers.length);
        return (from == to) ? null : new int[]{from, to};
    }

    private static int lowerBound(int x, int[] numbers, int from, int to) {
        while (from < to) {
            // "mid = (from + to) / 2" could overflow
            int mid = from + ((to - from) / 2);
            if (x <= numbers[mid]) { // find the beginning
                to = mid;
            } else if (numbers[mid] < x) {
                from = mid + 1;
            }
        }
        return from;
    }
}
