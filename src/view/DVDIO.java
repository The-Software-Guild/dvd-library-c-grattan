package view;

import java.time.*;
import java.util.Scanner;

public class DVDIO {

	Scanner in;
	
	public DVDIO(Scanner s) {
		in = s;
	}
	
	public void println(String msg)
	{
		System.out.println(msg);
	}
	
	public void print(String msg)
	{
		System.out.print(msg);
	}
	
	public String getString(String msg)
	{
		print(msg);
		return getString();
	}
	
	public String getString()
	{
		String input = "";
		do
		{
			input = in.nextLine();
		} while(input.isBlank());
		return input;
	}
	
	public int getInt()
	{
		return getInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public int getInt(String msg)
	{
		return getInt(msg, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public int getInt(String msg, int min, int max)
	{
		print(msg);
		return getInt(min, max);
	}
	
	public int getInt(int min, int max)
	{
		int input = 0;
		
		do
		{
			try
			{
				input = in.nextInt();
			}
			catch (Exception e)
			{
				in.next();
			}
		} while(input < min || input > max);
		
		return input; 
	}
	
	public LocalDate getDate(String msg)
	{
		print(msg);
		return getDate();
	}
	
	public LocalDate getDate()
	{
		LocalDate d = LocalDate.now();
		do
		{
			try
			{
				d = LocalDate.parse(in.nextLine());
			}
			catch (Exception e)
			{
				d = null;
			}
		} while(d != null);
		return d;
	}
}
