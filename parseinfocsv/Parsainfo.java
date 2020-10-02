package parseinfocsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parsainfo {
	public static String COMMA_DELIMITER = ",";

	public static void main(String[] args) {

		int namesWiA = 0;
		int assignWApp = 0;
		int assignArduino = 0;
		String letterCForA = "a";
		String workWAn = "Android App"; 
		String WorkArduino ="Arduino" ;
		
		List<List<String>> rec = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("sample.csv"));) {
			while (scanner.hasNextLine()) {
				rec.add(getRecordFromLine(scanner.nextLine()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		rec.remove(0); // this remove the first line in the CSV File

		// we check for different
		namesWiA = checkifAin(rec, letterCForA); // check how for A
		System.out.println("Names with the letter '" + letterCForA + "' is: " + namesWiA);
		assignWApp = checkiFAndroid(rec, workWAn); // check for people sign in with Android App
		System.out.println("There are " + assignWApp + " people signed in with" + workWAn);
		assignArduino = checkiFArduino(rec,  WorkArduino); // check for people sign in with Arduino
		System.out.println("There are: " +  assignArduino + " people signed in with " + WorkArduino);
		ceckaTimeStamp(rec); // we call the Method ceckaTimeStamp
	}

	private static int checkifAin(List<List<String>> list, String letter) {
		int i = 0;
		for (List<String> lista : list) {
			if (lista.get(1).toLowerCase().contains(letter)) {
				i++;
			}
			if (lista.get(2).toLowerCase().contains(letter)) {
				i++;
			}
		}

		return i;
	}

	private static int checkiFAndroid(List<List<String>> list, String assignment) {
		int i = 0;
		for (List<String> lista : list) {
			if (lista.get(6).equals(assignment)) {
				i = i + 2;
			}
		}
		return i;
	}
	private static int checkiFArduino(List<List<String>> list, String assignment) {
		int i = 0;
		for (List<String> lista : list) {
			if (lista.get(6).equals(assignment)) {
				i = i + 2;
			}
		}
		return i;
	}
	
	
	//Method ceckaTmestamp 
	//Here we compare if there are those with the same timestamp
	private static void ceckaTimeStamp(List<List<String>> list) {
		boolean usersWiSTime = false;

		for (List<String> lista : list) {  
			if (!lista.get(0).equals("")) {  // if there is a line that does not have a timestamp, then it is skipped
				
				int i = 0;
				for (List<String> lista2 : list) {
	if (lista.get(0).equals(lista2.get(0))) {  //Check if there are two that are the same
					
		i++;    
	if (i > 1) {  
							System.out.println("We found the same timestamp at:");
							usersWiSTime = true;
							System.out.println(lista.get(0) + ", " + lista.get(1));

						}
					}
				}
			}
		}

		if (usersWiSTime == false) { // if we not find any with the same timestamp then it false
			System.out.println("There are no people found with the same timestamp");
		}
		System.out.println();
	}
// end
	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}

		}

		return values;
	}

}