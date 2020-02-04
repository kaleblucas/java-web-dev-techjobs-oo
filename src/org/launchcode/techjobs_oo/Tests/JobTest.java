package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void emptyTest() {
        assertEquals(10, 10, .001);
    }

    Job test_emptyJobOne;
    Job test_emptyJobTwo;

    @Before
    public void createEmptyJobObjects() {
        test_emptyJobOne = new Job();
        test_emptyJobTwo = new Job();
    }

    @Test
    public void testUniqueIdInJobObjects() {
        createEmptyJobObjects();
        assertEquals((test_emptyJobOne.getId() + 1), test_emptyJobTwo.getId());
    }

    Job test_job;

    @Before
    public void createAllFieldsJobObject() {
        test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        createAllFieldsJobObject();
        assertEquals(test_job.getName(), "Product tester");
        assertTrue(test_job.getEmployer() instanceof Employer);
        assertTrue(test_job.getLocation() instanceof Location);
        assertTrue(test_job.getPositionType() instanceof PositionType);
        assertTrue(test_job.getCoreCompetency() instanceof CoreCompetency);
    }

    Job test_similarFieldsJobOne;
    Job test_similarFieldsJobTwo;

    @Before
    public void createSimilarFieldsJobObjects() {
        test_similarFieldsJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_similarFieldsJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
    @Test
    public void testJobsForEquality() {
        createSimilarFieldsJobObjects();
        assertFalse(test_similarFieldsJobOne.equals(test_similarFieldsJobTwo));
    }
}
