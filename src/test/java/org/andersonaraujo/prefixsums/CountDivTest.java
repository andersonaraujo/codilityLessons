package org.andersonaraujo.prefixsums;

import org.andersonaraujo.TestBase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link CountDiv}.
 */
public class CountDivTest extends TestBase {

    private static final int MAX_EXEC_TIME_MS = 500;

    private CountDiv instance = new CountDiv();

    @Test
    public void testSolution() {

        // Simple test
        Integer result = validateExecutionTime(() -> instance.solution(6, 11, 2), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 3, result.intValue());

        // Another simple test
        result = validateExecutionTime(() -> instance.solution(6, 11, 3), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 2, result.intValue());

        // Another simple test
        result = validateExecutionTime(() -> instance.solution(6, 11, 4), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 1, result.intValue());

        // Another simple test
        result = validateExecutionTime(() -> instance.solution(4, 11, 4), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 2, result.intValue());

        // Another simple test
        result = validateExecutionTime(() -> instance.solution(99, 102, 2), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 2, result.intValue());

        // Another simple test
        result = validateExecutionTime(() -> instance.solution(11, 345, 17), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 20, result.intValue());

        // Minimal test
        result = validateExecutionTime(() -> instance.solution(0, 0, 11), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 1, result.intValue());

        // Another simple test
        result = validateExecutionTime(() -> instance.solution(10, 10, 5), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 1, result.intValue());

        // Very large
        result = validateExecutionTime(() -> instance.solution(100, 23_000_000, 2), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 11499951, result.intValue());

        // Very large
        result = validateExecutionTime(() -> instance.solution(102, 123_000_000, 10_000), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", 12300, result.intValue());

        // Extremely large
        result = validateExecutionTime(() -> instance.solution(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE),
                MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 1, result.intValue());

    }

}