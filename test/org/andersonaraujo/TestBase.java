package org.andersonaraujo;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

import static org.junit.Assert.assertTrue;

/**
 * Base class for tests.
 */
public class TestBase {

    protected Object validateExecutionTime(Supplier function, long expectedMaxExecTime) {
        Instant start = Instant.now();
        Object result = function.get();
        Instant end = Instant.now();
        long executionTime = Duration.between(start, end).toMillis();
        assertTrue(String.format(
                "Execution time %d' is greater than max '%d'.", executionTime,
                expectedMaxExecTime), executionTime < expectedMaxExecTime);

        return result;
    }

}
