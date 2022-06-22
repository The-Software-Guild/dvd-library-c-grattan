package view;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;

import dto.DVD;

public class DVDView {

	private DVDIO io;
	
	public DVDView(DVDIO dio)
	{
		io = dio;
	}
	
	public void displayMenu()
	{
		io.println("Welcome to the DVD Library!\n1. View DVDs\n2. View a DVD\n3. Search by Title\n4. Add a DVD\n5. Remove a DVD\n6. Edit a DVD\n7. Exit");
	}
	
	public int getMenuChoice()
	{
		return io.getInt("Make your choice: ", 1, 7);
	}
	
	public void errorMsg()
	{
		io.println("Unrecognised input");
	}
	
	public void loadStatus(int size)
	{
		io.println((size == 0 ? "Did not load any" : "Loaded " + size) + " DVDs");
	}
	
	public String titlePrompt()
	{
		return io.getString("DVD Title: ");
	}
	
	public LocalDate datePrompt()
	{
		return io.getDate("Release Date (Year-Month-Date): ");
	}
	
	public String ratingPrompt()
	{
		return io.getString("MPAA Rating: ");
	}
	
	public String directorPrompt()
	{
		return io.getString("Director: ");
	}
	
	public String studioPrompt()
	{
		return io.getString("Studio: ");
	}
	
	public String userRatingPrompt()
	{
		return io.getString("Your Review: ");
	}
	
	public DVD dvdPrompt()
	{
		DVD dvd = new DVD();
		
		dvd.setTitle(titlePrompt());
		dvd.setDate(datePrompt());
		dvd.setRating(ratingPrompt());
		dvd.setDirector(directorPrompt());
		dvd.setStudio(studioPrompt());
		dvd.setUserRating(userRatingPrompt());
		
		return dvd;
	}
	
	public void displayDVD(DVD d)
	{
		io.println(d == null ? "DVD not found" : d.toString());
	}
	
	public void displayLibrary(HashMap<Integer, DVD> lib)
	{
		Set<Integer> keys = lib.keySet();
		for(int i : keys)
		{
			io.print(i + ": ");
			displayDVD(lib.get(i));
		}
	}
	
	public int idPrompt()
	{
		return io.getInt("Enter DVD ID: ");
	}
}
