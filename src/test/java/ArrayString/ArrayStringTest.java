package ArrayString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStringTest {

    @Test
    void allUnique() {
        assertTrue(ArrayString.allUnique("abcde"));
    }
}