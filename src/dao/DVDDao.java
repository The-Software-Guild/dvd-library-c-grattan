package dao;

import java.util.Collection;
import java.util.HashMap;

import java.time.format.DateTimeFormatter;

import java.io.PrintWriter;
import java.io.FileWriter;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Set;

import dto.*;

public class DVDDao {
	
	private HashMap<Integer, DVD> library = new HashMap<Integer, DVD>();
	
	private final String file;
	private DateTimeFormatter dtFormat;
	private final String delimiter;
	
	public HashMap<Integer, DVD> getLibrary()
	{
		return library;
	}
	
	private boolean unmarshall()
	{
		try
		{
			Scanner fileIn = new Scanner(
					new BufferedReader(
							new FileReader(file)));
			
			while(fileIn.hasNextLine())
			{
				library.put(library.size(), new DVD(fileIn.nextLine(), delimiter, dtFormat));
			}
			
			fileIn.close();
		}
		catch (Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	public DVDDao(String filePath, DateTimeFormatter dtf, String d)
	{
		dtFormat = dtf;
		file = filePath;
		delimiter = d;
		unmarshall();
	}
	
	public boolean commit()
	{
		PrintWriter out;
		
		try
		{
			out = new PrintWriter(new FileWriter(file));
		}
		catch (Exception e)
		{
			return false;
		}
		
		Collection<DVD> dvds = library.values();
		for(DVD dvd : dvds)
		{
			out.println(dvd.marshall(dtFormat, delimiter));
		}
		
		out.flush();
		out.close();
		return true;
	}

	public String getDateFormat()
	{
		return dtFormat.toString();
	}
	
	public DVD getByTitle(String title)
	{
		return library.get(getIndexByTitle(title));
	}
	
	public int getIndexByTitle(String title)
	{
		int i = -1;
		Set<Integer> keys = library.keySet();
		for(int key : keys)
		{
			if(library.get(key).getTitle().equals(title))
			{
				return key;
			}
		}
		return i;
	}
	
	public DVD addDVD(DVD d)
	{
		return library.put(library.size(), d);
	}
	
	public DVD removeDVD(int i)
	{
		return library.remove(i);
	}
	
	public DVD replaceDVD(int i, DVD d)
	{
		if(library.containsKey(i))
		{
			return library.put(i, d);
		}
		else
		{
			return library.get(i);
		}
	}
}
