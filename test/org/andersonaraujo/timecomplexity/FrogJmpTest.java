package org.andersonaraujo.timecomplexity;

import org.andersonaraujo.TestBase;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Test class for {@link FrogJmp}.
 */
public class FrogJmpTest extends TestBase {


    private FrogJmp frogJmp = new FrogJmp();

    @Test
    public void testSolution() {

        Integer result = validateExecutionTime(() -> frogJmp.solution(10, 85, 30), 1000, Integer.class);
        assertEquals("Invalid result.", 3, result.intValue());

    }

}