package controller;

import dao.*;
import view.*;

public class DVDController {

	DVDDao dao;
	DVDView view;
	
	public DVDController(DVDDao d, DVDView v) {
		dao = d;
		view = v;
		
		view.loadStatus(d.getLibrary().size());
	}
	
	public void run()
	{
		boolean running = true;
		
		while(running)
		{
			view.displayMenu();
			switch(view.getMenuChoice())
			{
			case 1:
				viewDVDs();
				break;
			case 2:
				viewDVD();
				break;
			case 3:
				searchByTitle();
				break;
			case 4:
				addDVD();
				break;
			case 5:
				removeDVD();
				break;
			case 6:
				editDVD();
				break;
			case 7:
				running = false;
				break;
			default:
				view.errorMsg();
			}
		}
		
		dao.commit();
	}

	private void viewDVDs()
	{
		view.displayLibrary(dao.getLibrary());
	}
	
	private void viewDVD()
	{
		int id = view.idPrompt();
		view.displayDVD(dao.getLibrary().get(id));
	}
	
	private void searchByTitle()
	{
		String title = view.titlePrompt();
		view.displayDVD(dao.getByTitle(title));
	}
	
	private void addDVD()
	{
		dao.addDVD(view.dvdPrompt());
	}
	
	private void removeDVD()
	{
		dao.removeDVD(view.idPrompt());
	}
	
	private void editDVD()
	{
		dao.replaceDVD(view.idPrompt(), view.dvdPrompt());
	}
}
