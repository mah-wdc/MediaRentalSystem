/*
 * Matthew Homan
 * May 9, 2023
 * CMIS 242 7382
 * Final Project - Media Rental System
 * 
 */

import java.util.Calendar;

//MusicCD class extends Media
public class MusicCD extends Media {
	
	// local attributes
	private int length;
	
	// constructor
	public MusicCD(int id, String title, int year, int length, boolean isAvailable) {
		
		super(id, title, year, isAvailable);
		this.length = length;
		
	}
	
	// get method
	public int getLength() {
		
		return length;
		
	}
	
	// set method
	public void setLength(int length) {
		
		this.length = length;
		
	}
	
	@Override
	public double calculateRentalFee() {
		
		double fee = length * 0.02; // basic fee
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		
		if (this.getYear() == currYear) {
			fee += 1;
		}
		
		return fee;
	}
	
	@Override
	public String toString() {
		
		return ("MusicCD [ id=" + getId() + ", title=" + getTitle() + ", year=" + getYear() + ", length=" + length + "min, availabl=" + isAvailable() + " ]\n");
		
	}
}