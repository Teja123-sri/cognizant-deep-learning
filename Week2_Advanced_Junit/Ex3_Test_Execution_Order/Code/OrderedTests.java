package Ex3_Test_Execution_Order.Code;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void initializeDatabase() {
        System.out.println("Step 1: Initialize database");
        assertTrue(true);
    }

    @Test
    @Order(2)
    void insertTestData() {
        System.out.println("Step 2: Insert test data");
        assertTrue(true);
    }

    @Test
    @Order(3)
    void verifyInsertedData() {
        System.out.println("Step 3: Verify inserted data");
        assertTrue(true);
    }
}

