

import java.util.Scanner;

import utils.ArrayUtils;

public class Main {
	public static void main(String[] args) throws Exception {
		String[] menu = {"Start a new Game", "Continue from last game"};
		String[] closedDoor = {"Open Door", "Move On"};
		String[] lockedDoor = {"Unlock Door", "Move On"};
		String[] findKey = {"Pick it up", "Leave it be"};
		Save.loadLast();
		int input = 0;
		Scanner kb = new Scanner(System.in);
		displayMenu(menu, 2);
		input = kb.nextInt();
		Map level1;
		Character p1;
		if (input == 1) {
			level1 =  new Map("lvlOne");
			level1.saveMap(Save.currentSave);
			p1 = new Character(Save.currentSave, "characterNew");
		} else {
			level1 =  new Map("mapDefault");
			p1 = new Character(Save.currentSave);
		}
		menu = new String[] {"Move Forward", "Move Back", "Move Left", "Move Right", "Exit Castle"};
		// int[] menuKey = {1, 2, 3, 4, 0};

		input = 0;
		int item = 1;
		System.out.println("\n\nYou enter an old castle..." + "\n What do you do?\n");
		do {
			displayMenu(menu, 2);
			input = kb.nextInt();
			if (input == 1) {
				item = level1.lookForward(p1.getX(), p1.getY());
			} else if (input == 2) {
				item = level1.lookBack(p1.getX(), p1.getY());
			} else if (input == 3) {
				item = level1.lookLeft(p1.getX(), p1.getY());
			} else if (input == 4) {
				item = level1.lookRight(p1.getX(), p1.getY());
			} else if (input != 5) {
				System.out.println("Not an option...");
			} else if (input == 5) {
				item = 10;
			}

			System.out.println("\n");
			
			if (item == 1) {
				System.out.println("You Encounter a wall");
			} else if (item == 0) {
				System.out.println("\n");
				System.out.println("You walk " + toDirection(input) + " down the hall");
				movePlayer(input, p1, level1);
			} else if (item == 2) {
				int inp2;
				System.out.println("You encounter a closed door");
				displayMenu(closedDoor);
				inp2 = kb.nextInt();
				if (inp2 == 1) {
					System.out.println("\n");
					System.out.println("You open the door, and walk through");
					movePlayer(input, p1, level1);
					level1.setValueAt(p1.getX(), p1.getY(), 5);
				} else System.out.println("No Mystery for you...");
			} else if (item == 5) {
				System.out.println("\n");
				System.out.println("You move " + toDirection(input) + " through the open door");
				movePlayer(input, p1, level1);
			} else if (item == 3) {
				int inp2;
				System.out.println("You encounter a locked door");
				displayMenu(lockedDoor, 2);
				inp2 = kb.nextInt();
				if (inp2 == 1) {
					if (ArrayUtils.linearSearch(p1.getInventoryArray(), 4) > -1) {
						System.out.println("\n");
						System.out.println("You take the key out of your pocket,\nUnlock the door, and walk through.");
						movePlayer(input, p1, level1);
						level1.setValueAt(p1.getX(), p1.getY(), 5);
					} else {
						System.out.println("\n");
						System.out.println("You don't have the key!\nFind it to open this door.");
					}
					
				} else System.out.println("No Mystery for you...");
			} else if (item == 4) {
				int inp2;
				movePlayer(input, p1, level1);
				System.out.println("You find a key at your feet!");
				displayMenu(findKey);
				inp2 = kb.nextInt();
				if (inp2 == 1) {
					System.out.println("\n");
					System.out.println("You pick up the key");
					p1.addInventory(4);
					level1.setValueAt(p1.getX(), p1.getY(), 0);
				} else System.out.println("No Mystery for you...");
			} else if (item == 7) {
				System.out.println("The castle door is locked!!!");
			} else if (item == 9) {
				System.out.println("You made it through the castle!\nThanks for playing...");
				input = 5;
			}



		} while (input != 5);
		Save.saveCurrent(p1, level1);
		
		kb.close();
	
		System.out.println("Come again soon.");

		
	}

	private static void displayMenu(String[] menu) {
		for (int ix = 0; ix < menu.length; ix++) {
			if ((ix+1)%2 == 0) {
				System.out.println((ix + 1) + ") " + menu[ix]);
			} else {
				System.out.print((ix + 1) + ") " + menu[ix] + "		");
			}
		}
		System.out.print("\n~~> ");
	}

	private static void displayMenu(String[] menu, int columns) {
		for (int ix = 0; ix < menu.length; ix++) {
			if ((ix+1)%columns == 0) {
				System.out.println((ix + 1) + ") " + menu[ix]);
			} else {
				System.out.print((ix + 1) + ") " + menu[ix] + "		");
			}
		}
		System.out.print("\n~~> ");
	}

	public static String toDirection(int dir) {
		if (dir == 1) {
			return "forward";
		} else if (dir == 2) {
			return "back";
		} else if (dir == 3) {
			return "left";
		} else if (dir == 4) {
			return "Right";
		} else return "nowhere";
		
	}
	private static void movePlayer(int dir, Character p, Map m) {
		if (dir == 1) {
			do {
				p.setY(p.getY() + 1);
			} while (m.lookForward(p.getX(), p.getY()) == 0 && m.lookLeft(p.getX(), p.getY()) == 1 && (m.lookRight(p.getX(), p.getY())) == 1);
			
		} else if (dir == 2) {
			p.setY(p.getY() - 1);
		} else if (dir == 3) {
			p.setX(p.getX() - 1);
		} else if (dir == 4) {
			p.setX(p.getX() + 1);
		}
	}
}