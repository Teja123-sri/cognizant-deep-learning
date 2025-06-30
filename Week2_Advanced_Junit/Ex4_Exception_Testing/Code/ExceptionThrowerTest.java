package Ex4_Exception_Testing.Code;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ExceptionThrowerTest {

    ExceptionThrower thrower = new ExceptionThrower();

    @Test
    void testThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(null);
        });
    }

    @Test
    void testNoExceptionThrown() {
        thrower.throwException("Valid Input");  // Should not throw any exception
    }
}
