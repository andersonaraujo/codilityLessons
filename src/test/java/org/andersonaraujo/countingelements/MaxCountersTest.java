package org.andersonaraujo.countingelements;

import org.andersonaraujo.TestBase;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * Test class for {@link MaxCounters}.
 */
public class MaxCountersTest extends TestBase {

    private static final int MAX_EXEC_TIME_MS = 500;

    private MaxCounters instance = new MaxCounters();

    @Test
    public void testSolution() {

        // Simple test
        int[] result = validateExecutionTime(() -> instance.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}),
                MAX_EXEC_TIME_MS, int[].class);
        assertEquals("Invalid result.", Arrays.toString(new int[]{3, 2, 2, 4, 2}), Arrays.toString(result));

        // Another simple test
        result = validateExecutionTime(() -> instance.solution(5, new int[]{6, 6, 6, 6, 6, 6}),
                MAX_EXEC_TIME_MS, int[].class);
        assertEquals("Invalid result.", Arrays.toString(new int[]{0, 0, 0, 0, 0}), Arrays.toString(result));


    }
}