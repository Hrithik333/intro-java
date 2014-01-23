import javax.swing.JFrame;

public class Main {
	public static int imgwidth = 204;
	public static int imgheight = 406;
	public static int gamewidth = 10;
	public static int gameheight = 22;
	public static int xoffset = 22;
	public static int yoffset = 16;
	
	public static boolean on = false;
	public static int currentwinx = 0;
	public static int currentwiny = 0;

	static int currentsid = 0;
	static int currenttid = 0;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(imgwidth + 16, imgheight + 38);
		frame.setLocation(200, 100);
		frame.setVisible(true);
		
		Display display = new Display();
		frame.add(display);
		
		//fills the grid with squares
		createtets();
		
		//initializes the grid
		display.init();
		
		settet(0, 0, 1);
		display.repaint();
	}
	
	private static void createtets() {
		for (int x = 0; x < gamewidth; x++) {
			for (int y = 0; y < gameheight; y++) {
				Grid.grid[x][y] = new Square(x, y);
			}
		}
	}
	
	public static void settet(int x, int y, int type) {
		Grid.grid[x][y].hastet = true;
		Grid.grid[x][y].squareid = 0;
		Grid.grid[x][y].tetrimoid = 0;
		Grid.grid[x][y].type = type;
	}
}