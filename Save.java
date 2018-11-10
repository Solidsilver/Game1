import java.io.File;
import java.util.Scanner;
import utils.*;
import characters.Character;

public class Save {

	public static String currentSave;


	public static void loadSave(String dirName) throws Exception {
		// File save = FileUtils.fileFactory(dirName);
	}

	public static void loadLast() throws Exception {
		Scanner fin = FileUtils.scannerFactory("lastSave");
		currentSave = fin.nextLine();
		fin.close();
		loadSave(currentSave);
	}
	

	public static void newSave(String dirName) throws Exception {
		File fn = new File("./" + dirName);
		if (fn.exists()) {
			System.out.println("Save by that name already exists");
		} else {
			fn.mkdir();
			currentSave = dirName;
		}
	}


	public static void saveCurrent(Character ch, Map ho) throws Exception {
		FileUtils.stringToFile(currentSave, "lastSave");
		ch.saveCharacter(currentSave);
		ho.saveMap(currentSave);
	}
	public static void saveCurrent(Character ch) throws Exception {
		FileUtils.stringToFile(currentSave, "lastSave");
		ch.saveCharacter(currentSave);

	}
	public static void saveCurrent(Map ho) throws Exception {
		FileUtils.stringToFile(currentSave, "lastSave");
		ho.saveMap(currentSave);

	}
	public static void saveCurrent() throws Exception {
		FileUtils.stringToFile(currentSave, "lastSave");
	}
}