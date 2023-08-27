package clubSimulation;
import java.util.concurrent.atomic.*;

public class PeopleCounter {
   private final Object lock = new Object(); /* Synchronization lock*/
	public AtomicInteger peopleOutSide; //counter for people arrived but not yet in the building
	private AtomicInteger peopleInside; //counter for patrons inside club
	private AtomicInteger peopleLeft; //counter for patrons who have left the club
	public AtomicInteger maxPeople; //maximum patrons allowed in the club at one time
	
      
	PeopleCounter(int max) {
		peopleOutSide= new AtomicInteger(0);
		peopleInside=new AtomicInteger(0);
		peopleLeft=new AtomicInteger(0);
		maxPeople=new AtomicInteger(max);
	}
		
	public int getWaiting() {
		return peopleOutSide.get();
	}

	public int getInside() {
      synchronized (lock) {
		return peopleInside.get();
	}
  }
	
	public int getTotal() {
      synchronized (lock) {
		return (peopleOutSide.get()+peopleInside.get()+peopleLeft.get());
	}
  }

	public int getLeft() {
      synchronized (lock) {
		return peopleLeft.get();
	}
  }
	
	public  int getMax() {
      synchronized (lock) {
		return maxPeople.get();
	}
  }
   
  	//someone arrived outside
	public synchronized void personArrived() {
     peopleOutSide.getAndIncrement();
  	}
  
	
	//someone got inside
	synchronized public void personEntered() {
		peopleOutSide.getAndDecrement();
		peopleInside.getAndIncrement();
      notify();
  
	}

	//someone left
	synchronized public void personLeft() {
		peopleInside.getAndDecrement();
		peopleLeft.getAndIncrement();
    
		
	}
	//too many people inside
	synchronized public boolean overCapacity() {
		if(peopleInside.get()>=maxPeople.get())
			return true;
		return false;
	}
	
	//not used
	synchronized public void resetScore() {
		peopleInside.set(0);
		peopleOutSide.set(0);
		peopleLeft.set(0);
	}
   
  
 

}