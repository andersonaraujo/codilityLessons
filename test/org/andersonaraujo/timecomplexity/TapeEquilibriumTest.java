package org.andersonaraujo.timecomplexity;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.time.Duration;
import java.time.Instant;

import org.andersonaraujo.TestBase;
import org.junit.Test;

/**
 * Test class for {@link TapeEquilibrium}.
 */
public class TapeEquilibriumTest extends TestBase {

    private TapeEquilibrium tp = new TapeEquilibrium();

    @Test
    public void testSolution() {
        validateSolution(new int[] { 3, 1, 2, 4, 3 }, 1, 1000);
        validateSolution(new int[] { 3, 1, 2, 4, 3 }, 1, 1000);
        validateSolution(new int[] { 3, 4, 2, 1, 3 }, 1, 1000);
        validateSolution(new int[] { 3, 4, 1 }, 2, 1000);
        validateSolution(createArray(Integer.MIN_VALUE, 100000), 552, 1000);
        validateSolution(createArray(Integer.MIN_VALUE, 100000000), 8, 1000);
    }

    private void validateSolution(int[] values, int expectedResult,
                                  long expectedMaxExecTime) {

        Object result = validateExecutionTime(() -> tp.solution(values), expectedMaxExecTime);
        assertEquals("Invalid result.", expectedResult, Integer.parseInt(result.toString()));

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
