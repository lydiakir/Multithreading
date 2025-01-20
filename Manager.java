package multithreading;

// The Manager class creates the Threads objects, starts them, and manages them.

import java.util.ArrayList;

public class Manager {
	
	public void runOneThread() {
		LKThread lkThread = new LKThread();
		System.out.println(Constant.CREATING + lkThread.getName());
		
		lkThread.start();
		try {
			Thread.sleep(Constant.MANAGERSLEEPTIME);
		}
		catch (InterruptedException e) {
			e.printStackTrace();		
		}
		
		System.out.println(Constant.INITIATEEXIT + lkThread.getName());
		lkThread.setExit();
		lkThread.interrupt();
		
		// Check that the thread has finished before exiting this method.
		while (lkThread.isAlive()) {
			System.out.println(Constant.WAITFOREND);
			try {
				lkThread.join(Constant.MANAGERSLEEPTIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return;
	}
	
	public void runManyThreads(int numberOfThreads) {
		ArrayList<LKThread> multiThreads = new ArrayList<LKThread>();
		for (int i = 0; i < numberOfThreads; i++) {
			LKThread lkThread = new LKThread();
			System.out.println(Constant.CREATING + lkThread.getName());
			multiThreads.add(i, lkThread);
		}
		
		for (LKThread lkThread : multiThreads) {
			lkThread.start();
		}
		
		try {
			Thread.sleep(Constant.MANAGERSLEEPTIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (LKThread lkThread : multiThreads) {
			lkThread.setExit();
			lkThread.interrupt();
			System.out.println(Constant.INITIATEEXIT + lkThread.getName());
		}
		
		// Check that the threads have all finished before exiting this method.
		for (LKThread lkThread : multiThreads) {
			while(lkThread.isAlive()) {
				System.out.println(Constant.WAITFOREND + lkThread.getName());
				try {
					lkThread.join(Constant.MANAGERSLEEPTIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(lkThread.getName() + Constant.STATE + lkThread.getState());
		}
		System.out.println(Constant.TERMINATE);
		return;
	}
	
	// Threads now have functionality instead of just sleeping.
	// Get each thread to wake up and either increment or decrement the value of a variable, returning the current value.
	public void runThreadsData(int numberOfThreads) {
		ArrayList<LKThread> multiThreads = new ArrayList<LKThread>();
		SynchronisedData synched = new SynchronisedData();
		for (int i = 0; i < numberOfThreads; i++) {
			LKThread lkThread = new LKThread(synched);
			System.out.println(Constant.CREATING + lkThread.getName());
			multiThreads.add(i, lkThread);
		}
		
		for (LKThread lkThread : multiThreads) {
			lkThread.start();
		}
		
		try {
			Thread.sleep(Constant.MANAGERSLEEPTIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (LKThread lkThread : multiThreads) {
			lkThread.setExit();
			lkThread.interrupt();
			System.out.println(Constant.INITIATEEXIT + lkThread.getName());
		}
		
		// Check that the threads have all finished before exiting this method.
		for (LKThread lkThread : multiThreads) {
			while(lkThread.isAlive()) {
				System.out.println(Constant.WAITFOREND + lkThread.getName());
				try {
					lkThread.join(Constant.MANAGERSLEEPTIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(lkThread.getName() + Constant.STATE + lkThread.getState());
		}
		System.out.println(Constant.TERMINATE);
		return;
	}

}
