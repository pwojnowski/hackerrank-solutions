package poligon.algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrongPasswordTest {

    @Test
    public void shouldFindStrongPassword() {
        assertEquals(3, StrongPassword.minimumNumber(3, "Ab1"));
    }
}