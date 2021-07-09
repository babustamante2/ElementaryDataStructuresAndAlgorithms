
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

	// This method will allow the user to populate the array manually.
	public static char[][] manPopulateArr(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.println("Pleae enter the character at position at " + i + " and " + j);
				arr[i][j] = scnr.next().charAt(0);
			}
		}
		System.out.println("Array Populated.");
		return arr;
	}

	// This method will populate the array with characters from a file
	// automatically. For testing purposes, I hard-coded the file path. Change the
	// filePath variable for your machine or place my txt files in your current
	// directory. The only exception handling is the FileNotFoundException. The
	// program will crash if the array size does not match the file input size.

	public static char[][] filePopulateArr(char[][] arr) {
		try {
			// Change the text in quotations("") to run the code on any text file of your
			// choosing.
			File filePath = new File("txtFiles/valid3.txt");
			Scanner readFile = new Scanner(filePath);
			// i is iterating through the rows, while j iterates through the columns of the
			// array.
			int i = 0;
			while (readFile.hasNextLine()) {
				String data = readFile.nextLine();
				// Parsing the line of text for individual characters
				for (int j = 0; j < data.length(); j++) {
					// Storing the character into the array
					arr[i][j] = data.charAt(j);
				}
				i++;
			}
			readFile.close();
			System.out.println("Array Populated.");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		return arr;
	}

	public static boolean isLatinSquare(char[][] arr) {
		// Checking the rows only
		int end = arr.length-1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				System.out.println(arr[i][0] + " == " + arr[i][j + 1]+ " ?" );
				if(arr[i][0] == arr[i][j + 1])
					return false;
			}
		}
		System.out.println("done");
		// Checking the columns only
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length -1; j++) {
				System.out.println(arr[0][i]+ " == " + arr[j + 1][i] + " ?" );
				if(arr[0][i] == arr[j + 1][i])
					return false;

			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		int sizeOfArr = getSize();
		char[][] arr = new char[sizeOfArr][sizeOfArr];
		// manPopulateArr(arr);
		arr = filePopulateArr(arr);
		System.out.println(isLatinSquare(arr));
		scnr.close();
	}

}
