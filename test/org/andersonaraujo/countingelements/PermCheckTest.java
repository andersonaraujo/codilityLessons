package org.andersonaraujo.countingelements;

import org.andersonaraujo.TestBase;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Test class for {@link PermCheck}
 */
public class PermCheckTest extends TestBase {

    private static final int MAX_EXEC_TIME_MS = 500;

    private static final int TRUE_FUNC_RETURN = 1;

    private static final int FALSE_FUNC_RETURN = 0;

    private PermCheck instance = new PermCheck();

    @Test
    public void testSolution() {

        // Simple test
        Integer result = validateExecutionTime(() -> instance.solution(new int[]{4, 1, 3, 2}), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", TRUE_FUNC_RETURN, result.intValue());

        // Another simple test
        result = validateExecutionTime(() -> instance.solution(new int[]{4, 1, 3}), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", FALSE_FUNC_RETURN, result.intValue());

        // Single element
        result = validateExecutionTime(() -> instance.solution(new int[]{1}), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", TRUE_FUNC_RETURN, result.intValue());

        // Another single element
        result = validateExecutionTime(() -> instance.solution(new int[]{2}), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", FALSE_FUNC_RETURN, result.intValue());

        // Double elements
        result = validateExecutionTime(() -> instance.solution(new int[]{2, 1}), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", TRUE_FUNC_RETURN, result.intValue());

        // Large array
        result = validateExecutionTime(() -> instance.solution(createArray(1, 10_000, 1)), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", TRUE_FUNC_RETURN, result.intValue());

        // Very large array (false)
        result = validateExecutionTime(() -> instance.solution(createArray(1, 10_000_000, 2)), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", FALSE_FUNC_RETURN, result.intValue());

    }
}
