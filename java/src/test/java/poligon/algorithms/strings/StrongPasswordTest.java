package poligon.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class StrongPasswordTest {

    @Test
    public void shouldFindStrongPassword() {
        assertEquals(3, StrongPassword.minimumNumber(3, "Ab1"));
    }
}