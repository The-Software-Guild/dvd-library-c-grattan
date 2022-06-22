package dvd_library;

import dao.*;
import controller.*;
import view.*;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		DVDDao dao = new DVDDao("library.txt", "yyyy MM dd", "::");
		
		Scanner in = new Scanner(System.in);
		DVDIO io = new DVDIO(in);
		
		DVDView view = new DVDView(io);
		
		DVDController control = new DVDController(dao, view);
		control.run();
	}

}
