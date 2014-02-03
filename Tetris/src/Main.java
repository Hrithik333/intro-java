//Documentation of the methods are in the method

import javax.swing.JFrame;

public class Main {
	//game and image dimensions
	public static int imgwidth = 204;
	public static int imgheight = 406;
	public static int gamewidth = 10;
	public static int gameheight = 22;
		
	//makes the game fullscreen (these variables will be the size of the screen)
	public static int currentwinx = 0;
	public static int currentwiny = 0;

	//game variables
	public static boolean gameon = false;
	static int currenttid = 0;
	
	public static Display display = new Display();

	
	public static void main(String[] args) {
		gameon = true;
				
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(imgwidth + 16, imgheight + 38);
		frame.setLocation(200, 100);
		frame.setVisible(true);
		
		frame.add(display);
		
		//fills the grid with squares
		createtets();
		
		//initializes the grid
		display.init();
		
		settet(2, 10, 0);
		
		Time.threadtimestart();
	
		testcase();
	}
	
	public static void createtets() {
		for (int x = 0; x < gamewidth; x++) {
			for (int y = 0; y < gameheight; y++) {
				Grid.grid[x][y] = new Square();
			}
		}
	}
	
	public static void settet(int x, int y, int type) {
		Grid.grid[x][y].hastet = true;
		Grid.grid[x][y].active = true;
		Grid.grid[x][y].tetrimoid = 0;
		Grid.grid[x][y].type = type;
	}
	
	private static void testcase() {
		int success = 0;
		int methodsuccess = 0;
		
		//test cases for method 1 - Display.findY()
		System.out.println("Method 1 Test Cases");
		System.out.println("calls Display.findY(), which takes a y value in the grid of Squares, and translates it into the y value taken by the Java draw methods, taking into account square width and the offset created by the image");
		newline();
		
		System.out.println("Method 1 Test 1: (1) -> (374)");
		System.out.println("Return: " + Display.findY(1));
		if (Display.findY(1) == 374) {
			success++;
			methodsuccess++;
			System.out.println("Case 1 Test 1 succeeded");
		} else {
			System.out.println("Case 1 Test 1 failed");
		}
		newline();
		
		System.out.println("Method 1 Test 2: (5) -> (310)");
		System.out.println("Test 2 Return: " + Display.findY(5));
		if (Display.findY(5) == 310) {
			success++;
			methodsuccess++;
			System.out.println("Case 1 Test 2 succeeded");
		} else {
			System.out.println("Case 1 Test 2 failed");
		}
		newline();
		
		System.out.println("Method 1 Test 3: (42) -> (-282)");
		System.out.println("Test 3 Return: " + Display.findY(42));
		if (Display.findY(42) == -282) {
			success++;
			methodsuccess++;
			System.out.println("Case 1 Test 3 succeeded");
		} else {
			System.out.println("Case 1 Test 3 failed");
		}
		newline();
		
		System.out.println(methodsuccess + " sucesses, " + (3-methodsuccess) + " failures in method 1");
		
		newline();
		
		
		
	}
	
	private static void newline() {
		System.out.println();
	}
}