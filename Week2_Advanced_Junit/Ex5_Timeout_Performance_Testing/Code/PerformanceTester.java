package Ex5_Timeout_Performance_Testing.Code;

public class PerformanceTester {

    public void performTask() {
        // Simulate some processing time
        try {
            Thread.sleep(500); // 500 milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

