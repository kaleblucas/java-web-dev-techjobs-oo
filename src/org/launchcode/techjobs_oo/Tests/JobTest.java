package org.launchcode.techjobs_oo.Tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void emptyTest() {
        assertEquals(10, 10, .001);
    }

    static Job test_emptyJobOne;
    static Job test_emptyJobTwo;

    @BeforeClass
    public static void createEmptyJobObjects() {
        test_emptyJobOne = new Job();
        test_emptyJobTwo = new Job();
    }

    @Test
    public void testUniqueIdInJobObjects() {
        createEmptyJobObjects();
        assertEquals((test_emptyJobOne.getId() + 1), test_emptyJobTwo.getId());
    }

    static Job test_job;
    @BeforeClass
    public static void createAllFieldsJobObject() {
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

    static Job test_similarFieldsJobOne;
    static Job test_similarFieldsJobTwo;
    @BeforeClass
    public static void createSimilarFieldsJobObjects() {
        test_similarFieldsJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_similarFieldsJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
    @Test
    public void testJobsForEquality() {
        createSimilarFieldsJobObjects();
        assertFalse(test_similarFieldsJobOne.equals(test_similarFieldsJobTwo));
    }

    static Job test_newLineTestJob;
    @BeforeClass
    public static void createNewLineTestJob() {
        test_newLineTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testToStringForNewLine(){
        createNewLineTestJob();
        assertEquals("\n",test_newLineTestJob.toString().substring(0,1));
        assertEquals("\n",test_newLineTestJob.toString().substring((test_newLineTestJob.toString().length()-1)));
    }

    static Job test_Job;
    @BeforeClass
    public static void createJobObject(){
        test_Job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
    }

    @Test
    public void testToStringForLabel(){
        createJobObject();
        assertTrue(test_Job.toString().contains("\nID:"));
        assertTrue(test_Job.toString().contains("\nName:"));
        assertTrue(test_Job.toString().contains("\nEmployer:"));
        assertTrue(test_Job.toString().contains("\nLocation:"));
        assertTrue(test_Job.toString().contains("\nPosition Type:"));
        assertTrue(test_Job.toString().contains("\nCore Competency:"));
    }


    static Job test_jobMissingField;
    @BeforeClass
    public static void createJobMissingField(){
        test_jobMissingField = new Job("Product tester", new Employer(), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
    }

    @Test
    public void testMissingFieldJob(){
        createJobMissingField();
        assertTrue(test_jobMissingField.toString().contains("Employer: No data available."));
    }
}
