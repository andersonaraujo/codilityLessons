package org.andersonaraujo;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

import static org.junit.Assert.assertTrue;

/**
 * Base class for tests.
 */
public class TestBase {

    protected <T> T validateExecutionTime(Supplier function, long expectedMaxExecTimeMs, Class<T> expectedType) {
        Instant start = Instant.now();
        Object result = function.get();
        Instant end = Instant.now();
        long executionTime = Duration.between(start, end).toMillis();
        assertTrue(String.format("Execution time %d' is greater than max '%d'.", executionTime, expectedMaxExecTimeMs),
                executionTime < expectedMaxExecTimeMs);

        return expectedType.cast(result);
    }

}
