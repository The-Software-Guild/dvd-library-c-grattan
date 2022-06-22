package dto;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DVD {
	
	private String title;
	private LocalDate date;
	private String rating;
	private String director;
	private String studio;
	private String userRating;
	
	@Override
	public String toString()
	{
		return title;
	}
	
	public DVD()
	{
		
	}
	
	public DVD(String fileInput, String delimiter, DateTimeFormatter dtf) throws Exception
	{
		String[] fields = fileInput.split(delimiter);
		if(fields.length == 6)
		{
			title = fields[0];
			date = LocalDate.parse(fields[1], dtf);
			rating = fields[2];
			director = fields[3];
			studio = fields[4];
			userRating = fields[5];
		}
		else
		{
			throw new Exception("Bad DVD data");
		}
	}
	
	public String marshall(DateTimeFormatter dtf, String delimiter)
	{
		return title + delimiter +
				date.format(dtf) + delimiter +
				rating + delimiter +
				director + delimiter + 
				studio + delimiter +
				userRating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getUserRating() {
		return userRating;
	}

	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}
}
