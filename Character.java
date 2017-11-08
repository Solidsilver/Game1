import utils.*;
import java.io.File;


public class Character {
	private String name;
	private int strength;
	private int maxHealth;
	private int posX;
	private int posY;
	private int level;
	private int[] items;

	
	Character() {
		this.name = "Isaiah";
		this.strength = 3;
		this.maxHealth = 10;
		this.posX = 1;
		this.posY = 1;
		this.level = 0;
		this.items = new int[0];
	}

	Character(String nm, int str, int mxH, int x, int y, int lvl, int[] itms) {
		this.name = nm;
		this.strength = str;
		this.maxHealth = mxH;
		this.posX = x;
		this.posY = y;
		this.level = lvl;
		this.items = itms;
	}

	Character(String saveName) throws Exception{
		String[] dat = FileUtils.fileToArray(saveName + "/characterDefault");
		this.name = dat[0];
		this.strength = Integer.parseInt(dat[1]);
		this.maxHealth = Integer.parseInt(dat[2]);
		this.posX = Integer.parseInt(dat[3]);
		this.posY = Integer.parseInt(dat[4]);
		this.level = Integer.parseInt(dat[5]);
		this.items = ArrayExtras.stringToArray(dat[6]);
	}
	Character(String saveName, String charName) throws Exception {
		String[] dat = FileUtils.fileToArray(saveName + "/" + charName);
		this.name = dat[0];
		this.strength = Integer.parseInt(dat[1]);
		this.maxHealth = Integer.parseInt(dat[2]);
		this.posX = Integer.parseInt(dat[3]);
		this.posY = Integer.parseInt(dat[4]);
		this.level = Integer.parseInt(dat[5]);
		this.items = ArrayExtras.stringToArray(dat[6]);
	}

	public String toString() {
		return this.name + "," + this.strength + "," + this.maxHealth;
	}

	public void saveCharacter(String saveName) throws Exception {
		String[] dat = new String[7];
		dat[0] = this.name;
		dat[1] = String.valueOf(this.strength);
		dat[2] = String.valueOf(this.maxHealth);
		dat[3] = String.valueOf(this.posX);
		dat[4] = String.valueOf(this.posY);
		dat[5] = String.valueOf(this.level);
		dat[6] = ArrayExtras.arrayToString(this.items);
		

		FileUtils.arrayToFile(dat, saveName + "/characterDefault");;
	}
	public void saveCharacter(String saveName, String charName) throws Exception {
		String[] dat = new String[7];
		dat[0] = this.name;
		dat[1] = String.valueOf(this.strength);
		dat[2] = String.valueOf(this.maxHealth);
		dat[3] = String.valueOf(this.posX);
		dat[4] = String.valueOf(this.posY);
		dat[5] = String.valueOf(this.level);
		dat[6] = ArrayExtras.arrayToString(this.items);

		FileUtils.arrayToFile(dat, saveName + "/" + charName);
	}

	public int strength() {
		return this.strength;
	}
	public String getInventory() {
		return ArrayExtras.arrayToString(this.items);
	}
	public int[] getInventoryArray() {
		return this.items;
	}
	public void removeInventory(int numb) throws Exception {
		this.items = ArrayUtils.remove(this.items, numb);
	}
	public void addInventory(int item) throws Exception {
		this.items = ArrayUtils.push(this.items, item);
	}

	public int getX() {
		return this.posX;
	}
	public int getY() {
		return this.posY;
	}

	public void setX(int newX) {
		this.posX = newX;
	}
	public void setY(int newY) {
		this.posY = newY;
	}

}