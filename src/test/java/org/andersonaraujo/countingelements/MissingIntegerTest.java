package org.andersonaraujo.countingelements;

import org.andersonaraujo.TestBase;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static junit.framework.Assert.assertEquals;

/**
 * Test class for {@link MissingInteger}.
 */
public class MissingIntegerTest extends TestBase {

    private static final int MAX_EXEC_TIME_MS = 500;

    private MissingInteger instance = new MissingInteger();

    @Test
    public void testSolution() {

        // Simple test
        Integer result = validateExecutionTime(() -> instance.solution(new int[]{1, 3, 6, 4, 1, 2}), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", 5, result.intValue());

        // One element
        result = validateExecutionTime(() -> instance.solution(new int[]{1}), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 2, result.intValue());

        // No elements
        result = validateExecutionTime(() -> instance.solution(new int[0]), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 1, result.intValue());

        // No missing element
        result = validateExecutionTime(() -> instance.solution(new int[]{1, 3, 6, 4, 5, 1, 2}), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", 7, result.intValue());

        // Large array (no missing)
        result = validateExecutionTime(() -> instance.solution(createArray(1, 10_000, 1)), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", 10_001, result.intValue());

        // Very large array (no missing)
        result = validateExecutionTime(() -> instance.solution(createArray(1, 10_000_000, 1)), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", 10_000_001, result.intValue());

        // Testing 10.000.000 elements, some random is missing
        int[] array = createArray(1, 10_000_000, 1);
        int removedIdx = new Random(new Date().getTime()).nextInt(10_000_000);
        int valueRemoved = array[removedIdx];
        array[removedIdx] = 10_000_001;
        result = validateExecutionTime(() -> instance.solution(array), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", valueRemoved, result.intValue());

        // Very large array with negative values (no missing)
        result = validateExecutionTime(() -> instance.solution(createArray(-100_000, 10_000_000, 1)), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", 9900000, result.intValue());


    }
}
