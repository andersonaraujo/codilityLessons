package org.andersonaraujo.countingelements;

import org.andersonaraujo.TestBase;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Test class for {@link FrogRiverOne}.
 */
public class FrogRiverOneTest extends TestBase {

    private static final int MAX_EXEC_TIME_MS = 500;

    private FrogRiverOne instance = new FrogRiverOne();

    @Test
    public void testSolution() {

        // Simple test
        Integer result = validateExecutionTime(() -> instance.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}),
                MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 6, result.intValue());

        // Another Simple test
        result = validateExecutionTime(() -> instance.solution(5, new int[]{1, 3, 1, 4, 2, 3, 17, 5, 4}),
                MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 7, result.intValue());

        // Single element
        result = validateExecutionTime(() -> instance.solution(1, new int[]{1}), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 0, result.intValue());

        // Never found
        result = validateExecutionTime(() -> instance.solution(7, new int[]{1, 3, 1, 4, 2, 3, 5, 4}), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", -1, result.intValue());

        // Large random
        result = validateExecutionTime(() -> instance.solution(10_000, createArray(0, 10_000, 1)), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", 9_999, result.intValue());

        // Extremely large random
        result = validateExecutionTime(() -> instance.solution(10_000_000, createArray(0, 10_000_000, 1)),
                MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 9_999_999, result.intValue());

    }
}
