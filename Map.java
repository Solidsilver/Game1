
import java.util.Random;
import utils.*;
public class Map {

	private int[][] mapGrid;
	// private int mapEntranceX = 0;
	// private int mapEntranceY = 1;


	//Constructors
	Map() {
		this.mapGrid = new int[10][10];
	}
	Map(int size) {
		this.mapGrid = new int[size][size];
	}
	Map(String levelName) throws Exception {
		loadMap(Save.currentSave, levelName);
	}

	public void setMapRandom(int sizeX, int sizeY) {
		Random rnd = new Random();
		int[][] map = this.mapGrid;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				this.mapGrid[i][j] = rnd.nextInt(9);

			}
		}
	}

	public void printMap() {
		int[][] map = this.mapGrid;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(this.mapGrid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int getValueAt(int x, int y) {
		return this.mapGrid[y][x];
	}
	public String getObjectValue(int itm) {
		if (itm == 0) {
			return "a hall";
		} else if (itm == 1) {
			return "a wall";
		} else if (itm == 2) {
			return "a closed door";
		} else if (itm == 3) {
			return "a locked door";
		} else if (itm == 4) {
			return "a key";
		} else if (itm == 5) {
			return "an open door";
		} else if (itm == 7) {
			return "the castle door";
		} else if (itm == 9) {
			return "an exit";
		} else {
			return "an Object that does not exist";
		}
	}
	public void setValueAt(int x, int y, int value) {
		this.mapGrid[y][x] = value;
	}

	public void saveMap(String dirName) throws Exception {
		FileUtils.arrayToFile(this.mapGrid, dirName + "/mapDefault");
	}
	public void saveMap(String dirName, String levelName) throws Exception {
		FileUtils.arrayToFile(this.mapGrid, dirName + "/" + levelName);
	}

	public String toString() {
		
		return "Map";
	}

	public void loadMap(String dirName) throws Exception {
		this.mapGrid = FileUtils.csvToArray(dirName + "/mapDefault");
	}
	public void loadMap(String dirName, String levelName) throws Exception {
		this.mapGrid = FileUtils.csvToArray(dirName + "/" + levelName);
	}

	public int lookLeft(int x, int y) {
		return this.mapGrid[y][x-1];
	}
	public int lookRight(int x, int y) {
		return this.mapGrid[y][x+1];
	}
	public int lookForward(int x, int y) {
		return this.mapGrid[y+1][x];
	}
	public int lookBack(int x, int y) {
		return this.mapGrid[y-1][x];
	}

	public int lookForward(Character c) throws Exception {
		int x = c.getX();
		int y = c.getY();
		if (c.getDirection() == 0) {
			return this.mapGrid[y][x+1];
		} else if (c.getDirection() == 1) {
			return this.mapGrid[y-1][x];
		} else if (c.getDirection() == 2) {
			return this.mapGrid[y][x-1];
		} else if (c.getDirection() == 3) {
			return this.mapGrid[y+1][x];
		} else {
			throw new Exception("Invalid Direction");
		}
	}
	public int lookBack(Character c) throws Exception {
		int x = c.getX();
		int y = c.getY();
		if (c.getDirection() == 0) {
			return this.mapGrid[y][x-1];
		} else if (c.getDirection() == 1) {
			return this.mapGrid[y+1][x];
		} else if (c.getDirection() == 2) {
			return this.mapGrid[y][x+1];
		} else if (c.getDirection() == 3) {
			return this.mapGrid[y-1][x];
		} else {
			throw new Exception("Invalid Direction");
		}
	}
	public int lookLeft(Character c) throws Exception {
		int x = c.getX();
		int y = c.getY();
		if (c.getDirection() == 0) {
			return this.mapGrid[y-1][x];
		} else if (c.getDirection() == 1) {
			return this.mapGrid[y][x-1];
		} else if (c.getDirection() == 2) {
			return this.mapGrid[y+1][x];
		} else if (c.getDirection() == 3) {
			return this.mapGrid[y][x+1];
		} else {
			throw new Exception("Invalid Direction");
		}
	}
	public int lookRight(Character c) throws Exception {
		int x = c.getX();
		int y = c.getY();
		if (c.getDirection() == 0) {
			return this.mapGrid[y+1][x];
		} else if (c.getDirection() == 1) {
			return this.mapGrid[y][x+1];
		} else if (c.getDirection() == 2) {
			return this.mapGrid[y-1][x];
		} else if (c.getDirection() == 3) {
			return this.mapGrid[y][x-1];
		} else {
			throw new Exception("Invalid Direction");
		}
	}


}