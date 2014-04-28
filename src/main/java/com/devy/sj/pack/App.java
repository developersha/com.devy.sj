package com.devy.sj.pack;

import java.util.Scanner;

import prop.FileUtils;
import prop.PropertiesReader;
import prop.PropertiesWriter;

/**
 * Console application to display results
 * 
 */
public class App {

	// Configuration file name
	static String propertiesFileName = "config.properties";

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

			try {
				processCommand(inputArray, inputCommand);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void processCommand(String[] inputArray,
			Commands inputCommand) throws Exception {
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

		case CONFIG:
			setConfig();
			break;
			
		case VCONFIG:
			viewConfigValues();
			break;
			
		case ADDCONFIG:
			addConfigKey();
			break;

		case NON_EXISTING:
			nonExistingCommand();
			break;
		}
	}

	private static void addConfigKey() {
		// TODO add new Key/Value
		System.out.println(" Set key - value to add.");	
	}

	private static void viewConfigValues() {
		System.out.println(" List of values from config file.");
		try {
			PropertiesReader reader = PropertiesReader.getInstance(propertiesFileName);
			
			for (String str:reader.readAll())
			{
				System.out.println(str);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void setConfig() {

		// check if configuration file exists
		// read setting
		if (FileUtils.isExists(propertiesFileName)) {
			System.out.println("Configuration file already exists.");
			System.out.println(" Type 'vconfig' to see the values.");
			System.out.println(" Type 'addconfig' to add new key/value.");
			
		} else {

			// if not - create new one
			try {
				// prepare configuration file
				PropertiesWriter writer = PropertiesWriter
						.getInstance(propertiesFileName);
				writer.write("dayPath", "C:/days/Day.txt");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// export day into text file
	private static void export() throws Exception {

		// read path for file from .properties file
		PropertiesReader reader = PropertiesReader
				.getInstance(propertiesFileName);
		String exportPath = reader.readByKey("dayPath");

		// make sure we have at least one day in the list
		if (mgr.Days.size() > 0) {
			Day day = mgr.Days.peekFirst();
			//serialize to xml
			day.exportXml("dayFile.xml");
			//serialize to txt file
			if (day.export(exportPath) == 0)
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
		System.out.println("<config> to set configuration file. ");
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

		// display list of days
		for (Day d : mgr.Days) {
			System.out.println(String.format("Day: %s", d.id));
		}
	}

	// handle <item> command
	private static void addNewItem() {
		System.out.println("Add new item:");
		System.out.println("Type the text:");
	}

	// handle <add> command
	private static void addNewDay(String[] params) {

		String date = "";

		// parse parameters
		if (params.length > 1 && params[1] != null)
			date = params[1];

		mgr.addDay(date);
		System.out.println(String.format("Day added: %s", date));
	}
}
