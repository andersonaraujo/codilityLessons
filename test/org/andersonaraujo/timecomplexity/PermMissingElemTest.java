package org.andersonaraujo.timecomplexity;

import org.andersonaraujo.TestBase;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static junit.framework.Assert.assertEquals;

/**
 * Test class for {@link PermMissingElem}
 */
public class PermMissingElemTest extends TestBase {

    private static final int MAX_EXEC_TIME_MS = 500;

    private PermMissingElem instance = new PermMissingElem();

    @Test
    public void testSolution() {

        // Simple unordered test
        Integer result = validateExecutionTime(() -> instance.solution(new int[]{2, 3, 1, 5}), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", 4, result.intValue());

        // Another simple unordered test
        result = validateExecutionTime(() -> instance.solution(new int[]{2, 5, 1, 4}), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 3, result.intValue());

        //
        result = validateExecutionTime(() -> instance.solution(new int[]{2, 5, 6, 1, 4, 3, 9, 7, 8, 11}),
                MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 10, result.intValue());

        // Testing 100.000 elements, the second is missing
        result = validateExecutionTime(() -> instance.solution(createArray(1, 100_000, 2)), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", 2, result.intValue());

        // Testing 100.000 elements, no missing
        result = validateExecutionTime(() -> instance.solution(createArray(1, 100_000, 1)), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", 100_001, result.intValue());

        // Testing 10.000.000 elements, some random is missing
        int[] array = createArray(1, 10_000_000, 1);
        int removedIdx = new Random(new Date().getTime()).nextInt(10_000_000);
        int valueRemoved = array[removedIdx];
        array[removedIdx] = 10_000_001;
        result = validateExecutionTime(() -> instance.solution(array), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", valueRemoved, result.intValue());

        // Test null parameter
        result = validateExecutionTime(() -> instance.solution(null), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 1, result.intValue());

        // Test empty array
        result = validateExecutionTime(() -> instance.solution(new int[0]), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 1, result.intValue());

        // Test single element
        result = validateExecutionTime(() -> instance.solution(new int[]{1}), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 2, result.intValue());

        // Test double element
        result = validateExecutionTime(() -> instance.solution(new int[]{1, 2}), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 3, result.intValue());

        // No missing (should return next element)
        result = validateExecutionTime(() -> instance.solution(new int[]{2, 3, 4, 1, 5}), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", 6, result.intValue());

        // Test missing first
        result = validateExecutionTime(() -> instance.solution(new int[]{3, 2}), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 1, result.intValue());

    }

}
