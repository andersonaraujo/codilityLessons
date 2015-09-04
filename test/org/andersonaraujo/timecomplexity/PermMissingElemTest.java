package org.andersonaraujo.timecomplexity;

import org.andersonaraujo.TestBase;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Test class for {@link PermMissingElem}
 */
public class PermMissingElemTest extends TestBase {

    public static final int MAX_EXEC_TIME_MS = 1000;
    private PermMissingElem instance = new PermMissingElem();

    @Test
    public void testNominalSolution() {

        Integer result = validateExecutionTime(() -> instance.solution(new int[]{2, 3, 1, 5}), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", 4, result.intValue());

        result = validateExecutionTime(() -> instance.solution(new int[]{2, 5, 1, 4}), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 3, result.intValue());

        result = validateExecutionTime(() -> instance.solution(new int[]{2, 5, 6, 1, 4, 3, 9, 7, 8, 11}),
                MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", 10, result.intValue());

        result = validateExecutionTime(() -> instance.solution(createArray(100, 100000, 2)), MAX_EXEC_TIME_MS,
                Integer.class);
        assertEquals("Invalid result.", 101, result.intValue());

        int[] array = createArray(1, 10000000, 1);
        int valueRemoved = array[1098];
        array[1098] = 0;
        result = validateExecutionTime(() -> instance.solution(array), MAX_EXEC_TIME_MS, Integer.class);
        assertEquals("Invalid result.", valueRemoved, result.intValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOffNominalSolutionWhenArgumentIsNull() {
        instance.solution(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOffNominalSolutionWhenArgumentIsEmptyArray() {
        instance.solution(new int[0]);
    }

}
