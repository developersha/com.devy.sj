package com.devy.sj.pack;

import java.util.Scanner;

/**
 * Console application to display results
 * 
 */
public class App {

	// Application manager
	static Manager mgr;
	
	//Console input reader
	static Scanner in;

	public static void main(String[] args) {
		mgr = new Manager();

		System.out.println("Welcome to SJ! ");
		System.out.println("Type <add> to create new day. ");
		System.out.println("Type <item> to create new item for today. ");
		System.out.println("Type <list> to view all days. ");
		System.out.println("Type <exit> to exit the application. ");

		in = new Scanner(System.in); 
		while (in.hasNext()) {
			String s = in.next(); 

			// process input
			switch (s) {
			case "add":
				addNewDay();
				break;

			case "item":
				addNewItem();
				break;

			case "list":
				viewList();
				break;

			case "exit":
				exit();
				break;
			}
		}
	}

	private static void exit() {
		System.out.println("bye");
		// close the scanner
		in.close();
		System.exit(0);
	}

	private static void viewList() {
		System.out.println("List of days:");

		if (mgr.Days.size() > 0) {
			System.out.println("Day entry: "
					+ mgr.Days.getFirst().Items.get(0).value);
		} else {
			System.out.println("  empty");
		}
	}

	private static void addNewItem() {
		System.out.println("Add new item:");
	}

	private static void addNewDay() {
		System.out.println("Add new day:");
		mgr.addToday();
	}
}
