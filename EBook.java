/*
 * Matthew Homan
 * May 9, 2023
 * CMIS 242 7382
 * Final Project - Media Rental System
 * 
 */

import java.util.Calendar;

//EBook class extends Media
public class EBook extends Media {
	
	// local attributes
	private int numChapters;
	
	// constructor
	public EBook(int id, String title, int year, int chapters, boolean isAvailable) {
		
		super(id, title, year, isAvailable);
		numChapters = chapters;
		
	}
	
	// get method
	public int getNumChapters() {
		
		return numChapters;
		
	}
	
	// set method
	public void setNumChapters(int numChapters) {
		
		this.numChapters = numChapters;
		
	}

	@Override
	public double calculateRentalFee() {
		
		double fee = numChapters * 0.10;		
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		
		if (this.getYear() == currentYear) {
			
			fee += 1;
		}
		
		return fee;
	}
	
	@Override
	public String toString() {
		
		return ("EBook [ id=" + getId() + ", title=" + getTitle() + ", year=" + getYear() + ", chapters=" + numChapters + ", available=" + isAvailable() + " ]\n");
		
	}
}