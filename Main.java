package multithreading;


public class Main {

	public static void main(String[] args) {
		
		Manager manageThreads = new Manager();
		
		manageThreads.runOneThread();
		manageThreads.runManyThreads(5);
		manageThreads.runThreadsData(5);
		System.exit(0);

	}

}
