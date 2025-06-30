package Ex2_TestSuites_Categories.Code;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class EvenCheckerTest {
    @Test
    void testEven() {
        assertTrue(4 % 2 == 0);
    }
}

