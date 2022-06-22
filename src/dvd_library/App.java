package dvd_library;

import java.time.format.DateTimeFormatter;

import dao.*;
import controller.*;
import view.*;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd");
		DVDDao dao = new DVDDao("library.txt", dtf, "::");
		
		Scanner in = new Scanner(System.in);
		DVDIO io = new DVDIO(in);
		
		DVDView view = new DVDView(io);
		
		DVDController control = new DVDController(dao, view);
		control.run();
	}

}
