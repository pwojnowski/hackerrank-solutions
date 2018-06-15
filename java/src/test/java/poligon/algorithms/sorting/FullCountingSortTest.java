package poligon.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FullCountingSortTest {

    private static final Object[][] TEST_DATA_1 = {
            {0, "ab"},
            {6, "cd"},
            {0, "ef"},
            {6, "gh"},
            {4, "ij"},
            {0, "ab"},
            {6, "cd"},
            {0, "ef"},
            {6, "gh"},
            {0, "ij"},
            {4, "that"},
            {3, "be"},
            {0, "to"},
            {1, "be"},
            {5, "question"},
            {1, "or"},
            {2, "not"},
            {4, "is"},
            {2, "to"},
            {4, "the"},
    };

    @Test
    public void shouldSortAnArray() {
        assertEquals("- - - - - to be or not to be - that is the question - - - -", FullCountingSort.sort(TEST_DATA_1));
    }
}
