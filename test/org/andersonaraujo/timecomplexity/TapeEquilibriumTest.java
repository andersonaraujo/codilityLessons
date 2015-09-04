package org.andersonaraujo.timecomplexity;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.andersonaraujo.TestBase;
import org.junit.Test;

/**
 * Test class for {@link TapeEquilibrium}.
 */
public class TapeEquilibriumTest extends TestBase {

    private TapeEquilibrium tp = new TapeEquilibrium();

    @Test
    public void testSolution() {
        validateSolution(new int[]{3, 1, 2, 4, 3}, 1, 1000);
        validateSolution(new int[]{3, 1, 2, 4, 3}, 1, 1000);
        validateSolution(new int[]{3, 4, 2, 1, 3}, 1, 1000);
        validateSolution(new int[]{3, 4, 1}, 2, 1000);
        validateSolution(createArray(Integer.MIN_VALUE, 100000, 1), 552, 1000);
        validateSolution(createArray(Integer.MIN_VALUE, 100000000, 1), 8, 1000);
    }

    private void validateSolution(int[] values, int expectedResult,
                                  long expectedMaxExecTime) {

        Integer result = validateExecutionTime(() -> tp.solution(values), expectedMaxExecTime, Integer.class);
        assertEquals("Invalid result.", expectedResult, result.intValue());

    }

}
