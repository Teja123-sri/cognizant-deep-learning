package Ex2_TestSuites_Categories.Code;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({EvenCheckerTest.class, OddCheckerTest.class})
public class AllTests {
    // No code needed here; JUnit will automatically run the listed classes
}

