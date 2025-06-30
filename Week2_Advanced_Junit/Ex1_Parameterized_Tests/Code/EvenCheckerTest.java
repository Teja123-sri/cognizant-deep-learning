package Ex1_Parameterized_Tests.Code;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckerTest {

    EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 100, -2, 0})
    public void testIsEvenWithEvenNumbers(int number) {
        assertTrue(checker.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 99, -1, 7})
    public void testIsEvenWithOddNumbers(int number) {
        assertFalse(checker.isEven(number), number + " should be odd");
    }
}
