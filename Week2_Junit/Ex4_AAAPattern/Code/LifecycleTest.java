package Ex4_AAAPattern.Code;

import org.junit.*;
import static org.junit.Assert.*;

public class LifecycleTest {
    private String name;

    @Before
    public void setUp() {
        name = "JUnit";
        System.out.println("Setup called");
    }

    @Test
    public void testName() {
        System.out.println("Test running");
        assertEquals("JUnit", name);
    }

    @After
    public void tearDown() {
        name = null;
        System.out.println("Teardown called");
    }
}
