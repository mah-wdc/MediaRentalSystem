/*
 * Matthew Homan
 * May 9, 2023
 * CMIS 242 7382
 * Final Project - Media Rental System
 * 
 * Manager Class
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Manager class manages the functionality of the program
//Contains methods to loadMedia, addMediaToFile, findMedia, and rentMedia
public class Manager {

	static List<Media> mediaList = new ArrayList<>();

	Manager() {} 

	//This method loads a file and parses the data into appropriate objects
	public boolean loadMedia(String fileName) throws IOException {

		try {

			BufferedReader reader1 = new BufferedReader(new FileReader(fileName));

			while (reader1.ready()) {

				String fileData = reader1.readLine();
				String[] partOfMedia = fileData.split(",");

				if (partOfMedia[0].equals("EBook")) {

					mediaList.add(new EBook(Integer.parseInt(partOfMedia[1]), partOfMedia[2], 
							Integer.parseInt(partOfMedia[3]), Integer.parseInt(partOfMedia[4]), 
							Boolean.parseBoolean(partOfMedia[5])));

				} else if (partOfMedia[0].equals("MusicCD")) {

					mediaList.add(new MusicCD(Integer.parseInt(partOfMedia[1]), partOfMedia[2], 
							Integer.parseInt(partOfMedia[3]), Integer.parseInt(partOfMedia[4]), 
							Boolean.parseBoolean(partOfMedia[5])));

				} else if (partOfMedia[0].equals("MovieDVD")) {

					mediaList.add(new MovieDVD(Integer.parseInt(partOfMedia[1]), partOfMedia[2], 
							Integer.parseInt(partOfMedia[3]), Double.parseDouble(partOfMedia[4]), 
							Boolean.parseBoolean(partOfMedia[5])));

				}

			}
			reader1.close();

			return true;

		} catch (FileNotFoundException e) {

			System.out.println("File cannot be opened: Could not load, no such directory.");

			return false;
		}

	}

	//This method allows a user to add media to the file that was loaded by updating the file and then reloading the file
	public void addMediaToFile(String fileName) throws IOException {

		FileWriter writer = new FileWriter(fileName, true);
		String dataToAdd;

		System.out.print("\nWhich type of media do you want to add to the media file:\n1. EBook\n2. MusicCD\n3. MovieDVD\n\n");
		Scanner scanner = new Scanner(System.in);
		int userSelection = scanner.nextInt();

		if (userSelection == 1) {

			System.out.print("\nPlease enter the id number: ");
			Scanner scanner0 = new Scanner(System.in);
			String tempID = scanner0.nextLine();

			System.out.print("\nPlease enter the title: ");
			Scanner scanner1 = new Scanner(System.in);
			String tempTitle = scanner1.nextLine();

			System.out.print("\nPlease enter the year it was published: ");
			Scanner scanner2 = new Scanner(System.in);
			String tempYear = scanner2.nextLine();

			System.out.print("\nPlease enter the number of chapters: ");
			Scanner scanner3 = new Scanner(System.in);
			String tempChapters = scanner3.nextLine();

			dataToAdd = "\nEBook," + tempID + "," + tempTitle + "," + tempYear + "," + tempChapters + ",true";
			writer.write(dataToAdd);

			mediaList.add(new EBook(Integer.parseInt(tempID), tempTitle, Integer.parseInt(tempYear), Integer.parseInt(tempChapters), true));
			
			loadMedia(fileName);

		} else if (userSelection == 2) {

			System.out.print("\nPlease enter the id number: ");
			Scanner scanner0 = new Scanner(System.in);
			String tempID = scanner0.nextLine();

			System.out.print("\nPlease enter the title: ");
			Scanner scanner4 = new Scanner(System.in);
			String tempTitle = scanner4.nextLine();

			System.out.print("\nPlease enter the year it was published: ");
			Scanner scanner5 = new Scanner(System.in);
			String tempYear = scanner5.nextLine();

			System.out.print("\nPlease enter the length of the CD: ");
			Scanner scanner6 = new Scanner(System.in);
			String tempLength = scanner6.nextLine();

			dataToAdd = "\nMusicCD," + tempID + "," + tempTitle + "," + tempYear + "," + tempLength + ",true";
			writer.write(dataToAdd);

			mediaList.add(new MusicCD(Integer.parseInt(tempID), tempTitle, Integer.parseInt(tempYear), Integer.parseInt(tempLength), true));
			
			loadMedia(fileName);

		} else if (userSelection == 3) {

			System.out.print("\nPlease enter the id number: ");
			Scanner scanner0 = new Scanner(System.in);
			String tempID = scanner0.nextLine();

			System.out.print("\nPlease enter the title: ");
			Scanner scanner7 = new Scanner(System.in);
			String tempTitle = scanner7.nextLine();

			System.out.print("\nPlease enter the year it was published: ");
			Scanner scanner8 = new Scanner(System.in);
			String tempYear = scanner8.nextLine();

			System.out.print("\nPlease enter the size of the file: ");
			Scanner scanner9 = new Scanner(System.in);
			String tempSize = scanner9.nextLine();

			dataToAdd = "\nMovieDCD," + tempID + "," + tempTitle + "," + tempYear + " " + tempSize + ",true";
			writer.write(dataToAdd);

			mediaList.add(new MovieDVD(Integer.parseInt(tempID), tempTitle, Integer.parseInt(tempYear), Double.parseDouble(tempSize), true));
			
			loadMedia(fileName);

		} else {

			System.out.println("Invalid selection");

		}

		writer.close();
	}

	//This method allows a user to find a specific type of media by title
	public void findMedia(String title) {

		boolean foundTitle = false;

		for (Media media : mediaList) {

			if (media.getTitle().equals(title)) {

				System.out.print(media.toString());
				foundTitle = true;

			} 
		}

		if (foundTitle == false) {

			System.out.println("There is no media with this title: " + title);

		}
	}

	//This method allows a user to rent media by id and calculates and prints the fee
	public void rentMedia(int id) {

		int count = 0;

		for (Media media : mediaList) {

			count++;

			if ((media.getId() == id) && (media.isAvailable())) {

				double num = media.calculateRentalFee();
				String roundedNum = String.format("%.2f", num);
				System.out.print("\nMedia was successfully rented. Rental fee = $" + roundedNum + ".\n");

				media.setAvailable(false);
				
				break;

			} else if ((media.getId() == id) && !(media.isAvailable())) {

				System.out.print("\nThe media exists but is currently unavailable.\n");
				
				break;

			} else if (count == (mediaList.size() - 1)) {

				System.out.print("\nThe media object id = " + id + " is not found.\n");

			}


		}

	}

}
