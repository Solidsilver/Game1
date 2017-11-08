

import java.util.Scanner;

import utils.ArrayUtils;

public class Main {
	public static void main(String[] args) throws Exception {
		Save.loadLast();
		Scanner kb = new Scanner(System.in);
		Map level1 =  new Map("lvlOne");
		Character p1 = new Character(Save.currentSave);

		p1.setX(1);
		p1.setY(0);

		level1.printMap();
		int input = 0;
		int item = 1;
		System.out.println("You enter an old castle..." + "\n What do you do?\n\n");
		do {
			System.out.println("\n\n\n1) Move Forward        2) Move Back\n" + 
									 "3) Move Left           4) Move Right\n" + 
									 "0) Exit Castle");
			input = kb.nextInt();
			if (input == 1) {
				item = level1.lookForward(p1.getX(), p1.getY());
			} else if (input == 2) {
				item = level1.lookBack(p1.getX(), p1.getY());
			} else if (input == 3) {
				item = level1.lookLeft(p1.getX(), p1.getY());
			} else if (input == 4) {
				item = level1.lookRight(p1.getX(), p1.getY());
			}
			System.out.println("Item: " + item);

			if (item == 1) {
				System.out.println("You Encounter a wall");
			} else if (item == 0) {
				System.out.println("You move " + toDirection(input));
				movePlayer(input, p1);
			} else if (item == 2) {
				int inp2;
				System.out.println("You encounter a closed door");
				System.out.println("1) Open door        2) Move on");
				inp2 = kb.nextInt();
				if (inp2 == 1) {
					System.out.println("You open the door, and walk through");
					movePlayer(input, p1);
					level1.setValueAt(p1.getX(), p1.getY(), 5);
				} else System.out.println("No Mystery for you...");
			} else if (item == 5) {
				System.out.println("You move " + toDirection(input) + " through an open door");
				movePlayer(input, p1);
			} else if (item == 3) {
				int inp2;
				System.out.println("You encounter a locked door");
				System.out.println("1) Unlock it        2) Move on");
				inp2 = kb.nextInt();
				if (inp2 == 1) {
					if (ArrayUtils.linearSearch(p1.getInventoryArray(), 4) > -1) {
						System.out.println("You take the key out of your pocket,\nUnlock the door, and walk through.");
						movePlayer(input, p1);
						level1.setValueAt(p1.getX(), p1.getY(), 5);
					} else {
						System.out.println("You don't have the key!\nFind it to open this door.");
					}
					
				} else System.out.println("No Mystery for you...");
			} else if (item == 4) {
				int inp2;
				movePlayer(input, p1);
				System.out.println("You find a key at your feet!");
				System.out.println("1) Pick it up        2) Leave it be");
				inp2 = kb.nextInt();
				if (inp2 == 1) {
					System.out.println("You pick up the key");
					p1.addInventory(4);
					level1.setValueAt(p1.getX(), p1.getY(), 0);
				} else System.out.println("No Mystery for you...");
			} else if (item == 9) {
				System.out.println("You made it through the castle!\nThanks for playing...");
				input = 0;
			} else if (item != 0) {
				System.out.println("Not an option...");
			}



		} while (input != 0);
		Save.saveCurrent(p1, level1);
		
		kb.close();
	
		System.out.println("Bye!");

		
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
	private static void movePlayer(int dir, Character p) {
		if (dir == 1) {
			p.setY(p.getY() + 1);
		} else if (dir == 2) {
			p.setY(p.getY() - 1);
		} else if (dir == 3) {
			p.setX(p.getX() - 1);
		} else if (dir == 4) {
			p.setX(p.getX() + 1);
		}
	}
}