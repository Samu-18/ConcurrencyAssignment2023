package clubSimulation;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ClubSimulationTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   
  private ClubSimulation clubSimulation;

    @Before
    public void setUp() {
        // Set up any common resources or conditions
        clubSimulation = new ClubSimulation(); // Create an instance of ClubSimulation
    }

    @Test
    public void testClubSimulationInitialization() {
        // Assert that the instance is not null and its properties are properly initialized
        Assert.assertNotNull(clubSimulation);
        // Add more assertions about the properties if needed
    }

    @Test
    public void teststartSim() {
        // Call the method to start the simulation
        clubSimulation.startSim();

        // Assert that the simulation has started (check the flag or any relevant state)
        Assert.assertTrue(ClubSimulation.started.get()); // Assuming started is a public AtomicBoolean field in ClubSimulation
    }

    @Test
    public void testPauseAndResumeSimulation() {
        // Call the methods to pause and resume the simulation
        clubSimulation.pauseSimulation();
        clubSimulation.resumeSimulation();

        // Assert that the simulation has been paused and resumed (check the flag or any relevant state)
        Assert.assertTrue(ClubSimulation.pause.get()); // Assuming pause is a public AtomicBoolean field in ClubSimulation
        Assert.assertFalse(ClubSimulation.pause.get()); // Assuming pause is toggled back to false after resume
    }

    @Test
    public void testQuitSimulation() {
        // Call the method to quit the simulation
        clubSimulation.quitSimulation();

        // Assert that the simulation has been terminated (check the flag or any relevant state)
        Assert.assertTrue(ClubSimulation.quit.get()); // Assuming quit is a public AtomicBoolean field in ClubSimulation
    }

}