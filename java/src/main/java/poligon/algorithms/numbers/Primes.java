package poligon.algorithms.numbers;

import java.util.*;

public class Primes {

    void checkPrime(int... args) {
        int maxNum = findMax(args);
        boolean[] primes = new boolean[maxNum + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        int maxPrime = (int) Math.sqrt(primes.length);
        for (int i = 2; i <= maxPrime; ++i) {
            if (primes[i]) {
                for (int x = i * i; x < primes.length; x += i) {
                    primes[x] = false;
                }
            }
        }
        for (int num : args) {
            if (primes[num]) System.out.print(num + " ");
        }
        System.out.println();
    }

    private int findMax(int[] nums) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }
        return max;
    }

    public static void main(String[] args) {
        String input =
                "9000002\n" +
                "9000001\n" +
                "9000003\n" +
                "9000004\n" +
                "9000005";
        try (Scanner scanner = new Scanner(input)) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            int n3 = scanner.nextInt();
            int n4 = scanner.nextInt();
            int n5 = scanner.nextInt();

            Primes primes = new Primes();
            long start = System.currentTimeMillis();
            primes.checkPrime(n1);
            System.out.printf("checkPrime(%d): %dms%n", n1, System.currentTimeMillis() - start);

            start = System.currentTimeMillis();
            primes.checkPrime(n1, n2);
            System.out.printf("checkPrime(%d, %d): %dms%n", n1, n2, System.currentTimeMillis() - start);

            start = System.currentTimeMillis();
            primes.checkPrime(n1, n2, n3);
            System.out.printf("checkPrime(%d, %d, %d): %dms%n", n1, n2, n3, System.currentTimeMillis() - start);

            start = System.currentTimeMillis();
            primes.checkPrime(n1, n2, n3, n4, n5);
            System.out.printf("checkPrime(%d, %d, %d, %d, %d): %dms%n",
                    n1, n2, n3, n4, n5, System.currentTimeMillis() - start);
        }
    }
}