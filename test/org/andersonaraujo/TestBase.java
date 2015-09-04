package org.andersonaraujo;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

import static org.junit.Assert.assertTrue;

/**
 * Base class for tests.
 */
public class TestBase {

    /**
     * Validates that a function is executed within a expected time.
     * @param function The function to be executed.
     * @param expectedMaxExecTimeMs The expected maximum execution time in miliseconds.
     * @param expectedReturnType The expected return type.
     * @return The result of the function execution.
     */
    protected <T> T validateExecutionTime(Supplier function, long expectedMaxExecTimeMs, Class<T> expectedReturnType) {
        Instant start = Instant.now();
        Object result = function.get();
        Instant end = Instant.now();
        long executionTime = Duration.between(start, end).toMillis();
        assertTrue(String.format("Execution time %d' is greater than max '%d'.", executionTime, expectedMaxExecTimeMs),
                executionTime < expectedMaxExecTimeMs);

        return expectedReturnType.cast(result);
    }

    /**
     * Creates an int array
     *
     * @param start The value to start the array
     * @param total The total of elements in the array
     * @param increment The increment of values
     * @return The int array
     */
    protected int[] createArray(int start, int total, int increment) {
        int[] array = new int[total];
        for (int i = 0; i < total; i++) {
            array[i] = start;
            start = start + increment;
        }
        return array;
    }

}
