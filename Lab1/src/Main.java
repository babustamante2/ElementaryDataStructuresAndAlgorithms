
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 *	Brandon Aaron Bustamante 
 * 	Elementary Data Structures and Algorithms
 * 
 *  DESCRIPTION 
 *  First, I created the method getSize(). This method aims to get the size of the array that
 *  will be the empty Latin Square. Next, I implemented the method to populate the array manually
 *  with characters. I accomplished this with the use of a nested for loop. To complete the method
 *  for populating the array automatically, I generated some txt files of sizes 3, 4, and 5. 
 */

public class Main {
	static Scanner scnr = new Scanner(System.in);

	// This method will prompt the user for the size of the array, and there is no
	// error checking or validation.
	public static int getSize() {
		System.out.println("Enter the desired size of the NxN array");
		int sizeOfArr = scnr.nextInt();
		return sizeOfArr;
	}

	// This method will allow the user to populate the array created manually.
	public static char[][] manPopulateArr(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.println("Pleae enter the character at position at " + i + " and " + j);
				arr[i][j] = scnr.next().charAt(0);
			}
		}
		return arr;
	}

	// This method will populate the array with characters from a file
	// automatically. For testing purposes, I hard-coded the file path. Change the
	// filePath variable for your machine or place my txt files in your current
	// directory.
	// FIXME: Only reads first line, needs to read entire file
	public static char[][] filePopulateArr(char[][] arr) {
		try {
			File filePath = new File("txtFiles/valid3.txt");
			Scanner readFile = new Scanner(filePath);
			while (readFile.hasNext()) {
//				String data = readFile.nextLine();
//				System.out.println(data);
				char data = readFile.next().charAt(0);
				System.out.println(data);
			}
			readFile.close();
			System.out.println("done");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		return arr;
	}

	public static void main(String[] args) {
		int sizeOfArr = getSize();
		char[][] arr = new char[sizeOfArr][sizeOfArr];
		// manPopulateArr(arr);
		filePopulateArr(arr);
		scnr.close();
	}

}
