package clubSimulation;

import org.junit.Test;
import static org.junit.Assert.*;

import clubSimulation.PeopleCounter;

public class PeopleCounterTest {
    @Test
    public void testPersonArrived() {
        PeopleCounter counter = new PeopleCounter(10);
        counter.personArrived();
        assertEquals(1, counter.getWaiting());
    }

    @Test
    public void testPersonEntered() {
        PeopleCounter counter = new PeopleCounter(10);
        counter.personEntered();
        assertEquals(1, counter.getInside());
    }

    @Test
    public void testPersonLeft() {
        PeopleCounter counter = new PeopleCounter(10);
        counter.personEntered();
        counter.personLeft();
        assertEquals(0, counter.getInside());
        assertEquals(1, counter.getLeft());
    }
 @Test
    public void testConcurrentPeopleArrivalAndEntry() throws InterruptedException {
        final PeopleCounter counter = new PeopleCounter(10);

        Thread thread1 = new Thread(() -> {
            counter.personArrived();
            counter.personEntered();
        });

        Thread thread2 = new Thread(() -> {
            counter.personArrived();
            counter.personEntered();
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assertEquals(2, counter.getInside());
    }
  }