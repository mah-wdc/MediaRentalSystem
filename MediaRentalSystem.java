/*
 * Matthew Homan
 * May 9, 2023
 * CMIS 242 7382
 * Final Project - Media Rental System
 * 
 * This program loads a data file of EBooks, MusicCDs, and MovieDVDs and 
 * allows a user to rent the item and displays the calculated fee. I have
 * also added a function to add media to the file.  They are then available
 * for the user to rent.
 */

import java.io.IOException;
import java.util.Scanner;

public class MediaRentalSystem {

	//Main method - runs the Menu method and processes user selection
	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		
		while (Menu()) {
			
			int userSelection = 0;
			
			System.out.print("\nEnter your selection: ");
			userSelection = scanner.nextInt();
			
			Manager m = new Manager();
			
			if (userSelection == 1) {
				
				System.out.print("\nEnter path (directory) where to load from: ");
				Scanner scanner2 = new Scanner(System.in);
				String fileName = scanner2.nextLine();
				
				m.loadMedia(fileName);
				
			} else if (userSelection == 2) {
				
				System.out.print("\nEnter the title: ");
				Scanner scanner3 = new Scanner(System.in);
				String title = scanner3.nextLine();
				
				m.findMedia(title);
				
			} else if (userSelection == 3) {
				
				System.out.print("\nEnter the id: ");
				Scanner scanner4 = new Scanner(System.in);
				int id = scanner4.nextInt();
				
				m.rentMedia(id);
				
			} else if (userSelection == 4) {
				
				System.out.print("\nEnter path (directory) of file which you want to add to: ");
				Scanner scanner5 = new Scanner(System.in);
				String fileName = scanner5.nextLine();
				
				try {
					
					m.addMediaToFile(fileName);
					
				} catch (IOException e) {
					
					System.out.println("\nNo such file path exists.");
					e.printStackTrace();
				}
				
			} else if (userSelection == 9) {
				
				System.out.println("\nThank you for using the program. Goodbye!");
				System.exit(0);
				
			}
			
		}
		
	}
	
	private static boolean Menu() {
		
		System.out.println("\nWelcome to media rental system");
		System.out.println("1: Load Media objects ");
		System.out.println("2: Find Media objects ");
		System.out.println("3: Rent Media objects ");
		System.out.println("4: Add Media object ");
		System.out.println("9: Exit ");
		
		return true;
	}


}