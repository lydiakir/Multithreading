package multithreading;

//Synchronised methods provide the locking mechanism, which stops multiple threads accessing the object at the same time.

public class SynchronisedData {
	
	private long  myProtectedInt = 0;
	
	public synchronized void incrementMyValue(String threadName) {
		myProtectedInt++;
		System.out.println(threadName + Constant.INCREMENTDATA + myProtectedInt);
	}
	
	public synchronized void decrementMyValue(String threadName) {
		myProtectedInt--;
		System.out.println(threadName + Constant.DECREMENTDATA + myProtectedInt);
	}
	
	public long getMyProtectedInt() {
		return myProtectedInt;
	}
}
