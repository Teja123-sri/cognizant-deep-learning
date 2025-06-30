import org.junit.Test;
import static org.junit.Assert.*;

public class SampleTest {
    @Test
    public void testMessage() {
        String message = "Hello JUnit!";
        assertEquals("Hello JUnit!", message);
    }
}
