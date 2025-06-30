package Ex2_TestSuites_Categories.Code;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class OddCheckerTest {
    @Test
    void testOdd() {
        assertTrue(5 % 2 != 0);
    }
}

