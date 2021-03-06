//Documentation of the methods are in the method

public class Time implements Runnable {
	//each level time is decreased as such:
	//0, 50, 75, 100, 125, 150, 175, 200, 225, 250
	
	//how much time the game should wait between levels
	private static int[] levWait = {1700, 1450, 1375, 1275, 1150, 1000, 825, 625, 325, 125, 1}; 
	
	//thread time repaints and calls methods after periods of time
	Thread time;

	//starts the thread time
	public static void threadTimeStart() {
		Thread time = new Thread(new Time());
		time.start();
	}
	
	//calls timeKeeping when the thread time starts
	public void run() {
		timeKeeping();
	}
	
	//keeps track of time, and calls methods that need to be called every drop
	public static void timeKeeping() {
		//random place stuff
		int rantime = 0;
		//the startTime helps keep track of how much time has passed since the loop started, which keeps the computer's performance from effecting game speed
		long startTime = System.currentTimeMillis();
		Main.display.repaint();
		sleep(startTime);
		
		//a loop that calls methods after every drop
		while (Main.gameOn) {
			startTime = System.currentTimeMillis();
			
			Physics.dropCall();
			Square.neighborFindCall();
						
			//random place stuff
			rantime++;
			if(rantime > 2) {
				Physics.randomPlace();
				rantime = 0;
			}
			
			Main.display.repaint();
			Physics.clearLineCheck();
			
			sleep(startTime);
						
			if (levWait[Levels.level -1]-(startTime-System.currentTimeMillis()) <= 0) {
				System.out.println("[Warning]: Did the time change, or is the game falling behind?");
			}
		}
	}
	
	private static void sleep(long startTime) {
		//sleeps for the amount of time alloted, removing how much time has passed since the beginning of the loop
		try {
			Thread.sleep(levWait[Levels.level -1]-(startTime-System.currentTimeMillis()));
		} catch (InterruptedException e) {
			System.out.println("Time thread died");
			e.printStackTrace();
		}
	}
}