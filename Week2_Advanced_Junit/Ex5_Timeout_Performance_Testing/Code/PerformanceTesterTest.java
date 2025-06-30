package Ex5_Timeout_Performance_Testing.Code;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.Test;

public class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();

    @Test
    void testPerformTaskCompletesWithin1Second() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            tester.performTask();
        });
    }
}

