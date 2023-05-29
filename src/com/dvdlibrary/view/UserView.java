package com.dvdlibrary.view;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dvdlibrary.dao.DvdDAOImpl;
import com.dvdlibrary.model.DVD;

public class UserView {
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	static DvdDAOImpl dvdDAOImpl = (DvdDAOImpl) context.getBean("DvdDAO");
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {	
		run();
	}
	
	public static void run() {
		
		while(true) {
			System.out.println("choose one option:");
			System.out.println("1: add a DVD to collection");
			System.out.println("2: remove DVD from a collection");
			System.out.println("3: edit information for an existing DVD");
			System.out.println("4: get all the DVDs in the collection");
			System.out.println("5: display DVD by ID");
			System.out.println("6: display DVD by title");
			
			int choice = Integer.parseInt(in.nextLine());
			if(choice == 1) insertView();
			else if(choice == 2) removeView();
			else if(choice == 3) editView();
			else if(choice == 4) getAllView();
			else if(choice == 5) searchByIdView();
			else if(choice == 6) searchByTitleView();
			else System.out.println("Invalid choice, please input number 1 - 6");
			
		}
	}
	
	public static void insertView() {
		System.out.println("Please input DVD information: title/ release date/ MPAA rating/"
				+ "director's name/ studio/ user rating or note");
		
		DVD dvd = new DVD();
		String title = in.nextLine();
		String releaseDate = in.nextLine();
		Double MPAARating = Double.parseDouble(in.nextLine());
		String director = in.nextLine();
		String studio = in.nextLine();
		String note = in.nextLine();
		
		dvd.setTitle(title);
		dvd.setReleaseDate(releaseDate);
		dvd.setRating(MPAARating);
		dvd.setDirector(director);
		dvd.setStudio(studio);
		dvd.setNotes(note);
		
		dvdDAOImpl.createDvd(dvd);
		System.out.println("DVD created! "+dvd);
		
	}
	
	public static void removeView() {
		System.out.println("Please input the DVD id that you want to remove:");
		int removeID= Integer.parseInt(in.nextLine());
		
		dvdDAOImpl.deleteDvd(removeID);
		System.out.println("DVD removed!");
	}
	
	public static void editView() {
		System.out.println("Please input the DVD id that you want to update:");
		int id = Integer.parseInt(in.nextLine());
		
		System.out.println("Please input the field that you want to update:"
				+ "1. title, 2. release date, 3. MPAA rating, 4. director's name, 5. studio, 6. user note");
		
		int updateID = Integer.parseInt(in.nextLine());
		if(updateID == 1) {
			System.out.println("New title: ");
			String title = in.nextLine();
			dvdDAOImpl.updateDvd(id, "title", title);
			System.out.println("Title updated!");
		}else if(updateID == 2) {
			System.out.println("New release date: ");
			String date = in.nextLine();
			dvdDAOImpl.updateDvd(id, "release_date", date);
			System.out.println("Release date updated!");
		}else if(updateID == 3) {
			System.out.println("New MPAA rating:");
			Double new_rating = Double.parseDouble(in.nextLine());
			dvdDAOImpl.updateDvd(id, "rating", new_rating);
			System.out.println("Rating updated!");
		}else if(updateID == 4) {
			System.out.println("New director:");
			String director = in.nextLine();
			dvdDAOImpl.updateDvd(id, "director", director);
			System.out.println("Director updated!");
		}else if(updateID == 5) {
			System.out.println("New studio:");
			String studio = in.nextLine();
			dvdDAOImpl.updateDvd(id, "studio", studio);
			System.out.println("Studio updated!");
		}
		else if(updateID == 6) {
			System.out.println("New user note:");
			String note = in.nextLine();
			dvdDAOImpl.updateDvd(id, "note", note);
			System.out.println("Notes updated!");
		}
	}
	
	public static void getAllView() {
		List<DVD> ret = dvdDAOImpl.getAllDvds();
		if(ret!=null) {
			for(DVD dvd:dvdDAOImpl.getAllDvds()) {
				System.out.println(dvd);
			}
		}else System.out.println("No DVD found");

	}
	
	public static void searchByTitleView() {
		System.out.println("DVD name:");
		String name = in.nextLine();
		List<DVD> ret = dvdDAOImpl.getDvdByName(name);
		if(ret!=null) {
			for(DVD dvd:ret) System.out.println(dvd);
		}
		else 
			System.out.println("No dvd named "+name);
	}
	
	public static void searchByIdView() {
		System.out.println("DVD ID:");
		int id = Integer.parseInt(in.nextLine());
		DVD ret = dvdDAOImpl.getDvdById(id);
		if(ret!=null) 
			System.out.println(dvdDAOImpl.getDvdById(id));
		else 
			System.out.println("No dvd of ID "+id);
	}
	

}
