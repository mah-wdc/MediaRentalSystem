/*
 * Matthew Homan
 * May 9, 2023
 * CMIS 242 7382
 * Final Project - Media Rental System
 * 
 */

//Media class - parent
public abstract class Media {
	
	// attributes
	private int id;
	private String title;
	private int year;
	private boolean isAvailable;
	
	// constructor
	public Media(int id, String title, int year, boolean isAvailable) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.isAvailable = isAvailable;
	}
	
	// get methods
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}

	// set methods
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	// calculate rental fee; for generic media it is flat fee $3.50
	public double calculateRentalFee() {
		
		return 3.50;
		
	}
}