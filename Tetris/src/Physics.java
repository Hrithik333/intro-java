//Physics class: makes blocks fall, clears lines, and checks whether there is "fusion"

//Documentation of the methods are in the method
public class Physics {
	
	public static void dropcall() {
		for (int x = 0; x < Main.gamewidth; x++) {
			for (int y = 0; y < Main.gameheight; y++) {
				drop(x, y);
			}
		}
	}
	
	public static void drop(int x, int y) {
		if (Grid.grid[x][y].hastet && Grid.grid[x][y].active) {
			Grid.grid[x][y].hastet = false;
			Grid.grid[x][y].active = false;
			
			Grid.grid[x][y -1].hastet = true;
			Grid.grid[x][y -1].active = true;
		}
	}
}
