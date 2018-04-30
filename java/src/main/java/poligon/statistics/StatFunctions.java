package poligon.statistics;

import java.util.Scanner;

public class StatFunctions {

    public static boolean isEven(int number) {
        return !isOdd(number);
    }

    public static boolean isOdd(int number) {
        return (number & 1) == 1;
    }

    /**
     * Get the number that is the midpoint (symmetry) of the array.
     * If the array has even number of elements the median is arithmetic mean of the two middle points.
     * If the array has odd number of elements the median is the central point.
     *
     * Assumes that the array is sorted.
     */
    public static double median(int[] numbers) {
        return median(numbers, 0, numbers.length);
    }

    /**
     * Calculate the arithmetic mean.
     */
    public static double mean(int[] array) {
        return ((double) sum(array))/array.length;
    }

    public static double median(int[] numbers, int from, int to) {
        final int midpoint = (from+to-1)/2;
        if (isEven(to-from)) {
            return (numbers[midpoint]+numbers[midpoint+1])/2.0;
        }
        return numbers[midpoint];
    }

    /**
     * Find the number that occurs most frequently or the smallest one from most frequent.
     */
    public static int mode(int[] array) {
        int mode = array[0];
        int modeCount = 0;
        int currentCount = 0;
        int prevValue = array[0];
        for (int value : array) {
            if (value != prevValue) {
                if (currentCount > modeCount) {
                    modeCount = currentCount;
                    mode = value;
                }
                currentCount = 1;
            } else {
                ++currentCount;
                if (currentCount > modeCount) {
                    modeCount = currentCount;
                    mode = value;
                }
            }
            prevValue = value;
        }
        return mode;
    }

    public static double[] quartiles(int[] data) {
        int endFirst = data.length/2;
        int startLast = endFirst;
        if (isOdd(data.length)) {
            ++startLast;
        }
        return new double[] { median(data, 0, endFirst),
                median(data, 0, data.length),
                median(data, startLast, data.length)
        };
    }

    public static int[] readArray(Scanner scanner, int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; ++i) {
            data[i] = scanner.nextInt();
        }
        return data;
    }

    public static int[] readArrayWithSize(Scanner scanner) {
        int[] data = new int[scanner.nextInt()];
        for (int i = 0; i < data.length; ++i) {
            data[i] = scanner.nextInt();
        }
        return data;
    }

    static double standardDeviation(int[] data) {
        return standardDeviation(data, mean(data));
    }

    private static double standardDeviation(int[] data, double mean) {
        double diffSum = 0;
        for (int value : data) {
            diffSum += Math.pow(value-mean, 2);
        }
        return Math.sqrt(diffSum / data.length);
    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
}
