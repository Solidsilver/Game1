

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Save.loadLast();
		Scanner kb = new Scanner(System.in);
		Map level1 =  new Map("lvlOne");
		Character p1 = new Character(Save.currentSave);

		level1.printMap();
		int input = 0;
		int item;
		System.out.println("You enter an old castle..." + "\n What do you do?\n\n");
		do {
			System.out.println("1) Move Forward        2) Move Back\n" + 
									 "3) Move Left           4) Move Right\n" + 
									 "0) Exit Castle");
			input = kb.nextInt();
			if (input == 1) {
				item = level1.lookForward(p1.getX(), p1.getY());
			}


		} while (input != 0);
		Save.saveCurrent(p1, level1);
		
		kb.close();
	
		System.out.println("Bye!");

		
	}

	public static void Exit() throws Exception {
		
	}
}