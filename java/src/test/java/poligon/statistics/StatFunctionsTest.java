package poligon.statistics;

import org.junit.Test;

import java.util.Scanner;

import static poligon.statistics.StatFunctions.*;
import static org.junit.Assert.*;

public class StatFunctionsTest {

    private static final double DELTA = 0.0001d;

    @Test
    public void shouldFindEvenNumbers() {
        assertTrue(isEven(-2));
        assertTrue(isEven(0));
        assertTrue(isEven(2));
        assertTrue(isEven(100));

        assertFalse(isEven(-7));
        assertFalse(isEven(1));
    }

    @Test
    public void shouldFindOddNumbers() {
        assertFalse(isOdd(-2));
        assertFalse(isOdd(0));
        assertFalse(isOdd(2));
        assertFalse(isOdd(100));

        assertTrue(isOdd(-7));
        assertTrue(isOdd(1));
    }

    @Test
    public void shouldCalculateMean() {
        assertEquals(0, mean(new int[] {0}), DELTA);
        assertEquals(30, mean(new int[] {10, 40, 30, 50, 20}), DELTA);
    }

    @Test
    public void shouldFindMedian() {
        assertEquals(42, median(new int[] {42}), DELTA);
        assertEquals(1.5, median(new int[] {1, 2}), DELTA);
        assertEquals(12.0, median(new int[] {3, 5, 7, 8, 12, 13, 14, 18, 21}), DELTA);
        assertEquals(6.0, median(new int[] {3, 5, 7, 8}), DELTA);
        assertEquals(16.0, median(new int[] {13, 14, 18, 21}), DELTA);
    }

    @Test
    public void shouldFindMedianInRange() {
        assertEquals(42, median(new int[] {42}, 0, 1), DELTA);
        assertEquals(1.5, median(new int[] {1, 2}, 0, 2), DELTA);
        int[] numbers = {3, 5, 7, 8, 12, 13, 14, 18, 21};
        assertEquals(12.0, median(numbers, 0, numbers.length), DELTA);
        assertEquals(6.0, median(numbers, 0, 4), DELTA);
        assertEquals(16.0, median(numbers, 5, numbers.length), DELTA);
    }

    @Test
    public void shouldCalculateQuartiles() {
        assertArrayEquals(new double[]{ 3, 5, 7 },
                quartiles(new int[]{3, 7}), DELTA);
        assertArrayEquals(new double[]{ 6, 12, 16 },
                quartiles(new int[]{3, 5, 7, 8, 12, 13, 14, 18, 21}), DELTA);
    }

    @Test
    public void shouldReturnSumOfNumbers() {
        assertEquals(0, sum(new int[0]));
        assertEquals(101, sum(new int[]{3, 5, 7, 8, 12, 13, 14, 18, 21}));
        assertEquals(0, sum(new int[] { -5, -3, 1, 2, 4, 1}));
    }

    @Test
    public void shouldReadArrayWithSizeFromScanner() {
        try (Scanner scanner = new Scanner("1\n3\n")) {
            assertArrayEquals(new int[] {3}, readArrayWithSize(scanner));
        }
        try (Scanner scanner = new Scanner("3\n-5 0 42")) {
            assertArrayEquals(new int[]{-5, 0, 42}, readArrayWithSize(scanner));
        }
    }

    @Test
    public void shouldReadArrayFromScanner() {
        try (Scanner scanner = new Scanner("-5 0 42")) {
            assertArrayEquals(new int[0], readArray(scanner, 0));
        }
        try (Scanner scanner = new Scanner("-5 0 42")) {
            assertArrayEquals(new int[]{-5, 0}, readArray(scanner, 2));
        }
        try (Scanner scanner = new Scanner("-5 0 42")) {
            assertArrayEquals(new int[]{-5, 0, 42}, readArray(scanner, 3));
        }
    }

    @Test
    public void shouldCalculateStandardDeviation() {
        assertEquals(14.14213, standardDeviation(new int[] {10, 40, 30, 50, 20}), DELTA);
    }
}
