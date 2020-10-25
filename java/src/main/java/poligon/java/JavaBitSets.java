package poligon.java;

import java.util.*;

public class JavaBitSets {

    private final Scanner scanner;
    private BitSet b1, b2;

    JavaBitSets(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JavaBitSets jbs = new JavaBitSets(scanner);
        jbs.process();
    }

    void process() {
        createBitsets();
        int operations = scanner.nextInt();

        while (operations-- > 0) {
            processNextOperation();
            printSetBits();
        }
        scanner.close();
    }

    private void createBitsets() {
        int bitsetSize = scanner.nextInt();
        b1 = new BitSet(bitsetSize);
        b2 = new BitSet(bitsetSize);
    }

    private void applyAnd(int target, int __) {
        if (target == 1) { b1.and(b2); } else { b2.and(b1); }
    }

    private void applyOr(int target, int __) {
        if (target == 1) { b1.or(b2); } else { b2.or(b1); }
    }

    private void applyXor(int target, int __) {
        if (target == 1) { b1.xor(b2); } else { b2.xor(b1); }
    }

    private void applyFlip(int bitset, int bit) {
        if (bitset == 1) { b1.flip(bit); } else { b2.flip(bit); }
    }

    private void applySet(int bitset, int bit) {
        if (bitset == 1) { b1.set(bit); } else { b2.set(bit); }
    }

    private void processNextOperation() {
        String op = scanner.next();
        if ("AND".equals(op)) {
            applyAnd(scanner.nextInt(), scanner.nextInt());
        } else if ("OR".equals(op)) {
            applyOr(scanner.nextInt(), scanner.nextInt());
        } else if ("XOR".equals(op)) {
            applyXor(scanner.nextInt(), scanner.nextInt());
        } else if ("FLIP".equals(op)) {
            applyFlip(scanner.nextInt(), scanner.nextInt());
        } else if ("SET".equals(op)) {
            applySet(scanner.nextInt(), scanner.nextInt());
        }
    }

    private void printSetBits() {
        System.out.println(b1.cardinality() + " " + b2.cardinality());
    }
}
