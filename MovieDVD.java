/*
 * Matthew Homan
 * May 9, 2023
 * CMIS 242 7382
 * Final Project - Media Rental System
 * 
 */

//MovieDCD class extends Media
public class MovieDVD extends Media {
	
	// local attributes
	private double size;
	
	// constructor
	public MovieDVD(int id, String title, int year, double size, boolean isAvailable) {
		
		super(id, title, year, isAvailable);
		this.size = size;
		
	}
	
	// get method
	public double getSize() {
		
		return size;
		
	}
	
	// set method
	public void setSize(double size) {
		
		this.size = size;
		
	}
	
	@Override
	public String toString() {
		
		return ("MovieDVD [ id=" + getId() + ", title=" + getTitle() + ", year=" + getYear() + ", size=" + size + "MB, available=" + isAvailable() + " ]\n");
		
	}
}