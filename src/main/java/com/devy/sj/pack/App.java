package com.devy.sj.pack;

import java.util.Scanner;

/**
 * Console application to display results
 * 
 */
public class App {

	// Application manager
	static Manager mgr;

	// Console input reader
	static Scanner in;

	public static void main(String[] args) {

		System.out.println("Welcome to SJ! ");

		mgr = new Manager();
		in = new Scanner(System.in);

		while (in.hasNext()) {
			String s = in.nextLine();

			String[] inputArray = s.split(" ");
			Commands inputCommand = Commands.NON_EXISTING;
			try {
				inputCommand = Commands.valueOf(inputArray[0].toUpperCase());
			} catch (IllegalArgumentException ex) {
				// swallow this type of exception, as it's handled by
				// NON_EXISTING value
			}

			processCommand(inputArray, inputCommand);
		}
	}

	private static void processCommand(String[] inputArray,
			Commands inputCommand) {
		// process input
		switch (inputCommand) {
		case ADD:
			addNewDay(inputArray);
			break;

		case ITEM:
			addNewItem();
			break;

		case LIST:
			viewList();
			break;

		case EXIT:
			exit();
			break;

		case HELP:
			displayHelp();
			break;
			
		case EXPORT:
			export();
			break;

		case NON_EXISTING:
			nonExistingCommand();
			break;
		}
	}

	//export day into text file
	private static void export() {
		
		//make sure we have at least one day in the list
		if (mgr.Days.size() > 0)
		{
			Day day = mgr.Days.peekFirst();
			if (day.export() == 0)
				System.out.println("Export: successful. ");
			else
				System.out.println("Export: failed. ");
		}
	}

	// Display help screen
	private static void displayHelp() {
		System.out.println("<add> to create new day. ");
		System.out.println("<item> to create new item for today. ");
		System.out.println("<list> to view all days. ");
		System.out.println("<exit> to exit the application. ");
		System.out.println("<help> to display this screen. ");
	}

	// Handle non-existing command
	private static void nonExistingCommand() {
		System.out
				.println("Incorrect command. Type -help- to see list of commands.");
	}

	// handle <exit> command
	private static void exit() {
		System.out.println("bye");
		// close the scanner
		in.close();
		System.exit(0);
	}

	// handle <list> command
	private static void viewList() {
		System.out.println("List of days:");

		if (mgr.Days.size() == 0)
			System.out.println("  empty");

		//display list of days
		for (Day d : mgr.Days) {
			System.out.println(String.format("Day: %s", d.id));
		}
	}

	// handle <item> command
	private static void addNewItem() {
		System.out.println("Add new item:");
		System.out.println("Type the text:");
	}

	//handle <add> command
	private static void addNewDay(String[] params) {

		String date = "";

		// parse parameters
		if (params.length > 1 && params[1] != null)
			date = params[1];

		mgr.addDay(date);
		System.out.println(String.format("Day added: %s", date));
	}
}
