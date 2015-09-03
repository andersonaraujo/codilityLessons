package org.andersonaraujo.timecomplexity;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.time.Duration;
import java.time.Instant;

import org.junit.Test;

/**
 * Test class for {@link TapeEquilibrium}.
 */
public class TapeEquilibriumTest {

    private TapeEquilibrium tp = new TapeEquilibrium();

    @Test
    public void test() {
        validateSolution(new int[] { 3, 1, 2, 4, 3 }, 1, 1000);
        validateSolution(new int[] { 3, 1, 2, 4, 3 }, 1, 1000);
        validateSolution(new int[] { 3, 4, 2, 1, 3 }, 1, 1000);
        validateSolution(new int[] { 3, 4, 1 }, 2, 1000);
        validateSolution(createArray(Integer.MIN_VALUE, 100000), 552, 1000);
        validateSolution(createArray(Integer.MIN_VALUE, 100000000), 8, 1000);
    }

    @SuppressWarnings("deprecation")
    private void validateSolution(int[] values, int expectedResult,
                                  long expectedMaxExecTime) {
        Instant start = Instant.now();
        assertEquals("Invalid result.", expectedResult, tp.solution(values));
        Instant end = Instant.now();
        long executionTime = Duration.between(start, end).toMillis();
        assertTrue(String.format(
                "Execution time %d' is greater than max '%d'.", executionTime,
                expectedMaxExecTime), executionTime < expectedMaxExecTime);

    }

    private int[] createArray(int start, int total) {
        int[] array = new int[total];
        for (int i = 0; i < total; i++) {
            // System.out.println("i: " + i);
            array[i] = start + i;
        }
        return array;
    }

}
