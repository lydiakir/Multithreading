package multithreading;

import java.util.Random;

/* When the thread is started it sits in a while (!isExiting) { } loop containing the Thread.sleep(threadSleep); statement, waking
up every 1000 milliseconds to see if the isExiting flag is set to true. When the thread wakes up and its isExiting is set to true it will
drop out of the while loop, set the isStarted to false and then exit the run method. */

public class LKThread extends Thread {
	
	private boolean isExiting = false;
	private boolean isSynchronised = false;
	private SynchronisedData synchronisedData;
	private Random rand = new Random();
	
	public LKThread() {
		// default constructor
	}
	
	public LKThread(SynchronisedData dataToIncrement) {
		synchronisedData = dataToIncrement;
		isSynchronised = true;
		System.out.println(Constant.SYNCHRONISED + this.getName());
	}
	
	public void run() {
		System.out.println(Constant.RUNNING + this.getName());
		while(!isExiting) {
			if (isSynchronised == true) {
				int incrementDecider = rand.nextInt(10);
				if (incrementDecider % 2 == 0) {
					synchronisedData.incrementMyValue(this.getName());
				}
				else {
					synchronisedData.decrementMyValue(this.getName());
				}
			}
			try {
				Thread.sleep(Constant.CHECKISEXITINGSLEEPTIME);
				System.out.println(this.getName() + Constant.WOKEN);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(this.getName() + Constant.EXITING);
		return;
	}
	
	public void setExit() {
		isExiting = true;
		return;
	}
	
	public boolean getIsExiting() {
		return isExiting;
	}
	
	public void setIsSynchronised(boolean isThreadSynchronised) {
		isSynchronised = isThreadSynchronised;
		return;
	}
	
	public boolean getIsSynchronised() {
		return isSynchronised;
	}
	
}
