package com.devy.sj.pack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

//The class represents the day of the journal
public class Day extends Item {

	// List of items per the day
	List<Item> Items;

	public Day() {
		Items = new ArrayList<Item>();
	}

	public Day(String date) {
		if (isValidateDate(date)) {
			id = date;
			Items = new ArrayList<Item>();
		}
	}
	
	//prepare text to be saved in the file
	public String toString()
	{	
		StringBuilder sb = new StringBuilder();
		sb.append("Day: ");
		sb.append("\n");		
		sb.append(String.format("ID: %s", id));
		sb.append("\n");		
		sb.append(String.format("Value: %s", value));
		sb.append("\n");		
		sb.append(String.format("Number of items: %s", this.Items.size()));			
		
		return sb.toString();		
	}
	
	public void addItem(Item item) {
		Items.add(item);
	}

	private boolean isValidateDate(String date) {

		// TODO: date must be in valid format
		
		return true;
	}
	
	//Export day info into text file
	//return 0 in case of successful export
	//return 1 in case of error
	public int export(String fileName)
	{
		int result = 1;
		//create new file
		PrintWriter writer = null;
		try {						
			//TODO: make sure folder exists >> fileName
			
			writer = new PrintWriter(fileName, "UTF-8" );			
			writer.println(this.toString());	
			result = 0;			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			result = 1;			
		}
		finally
		{
			writer.close();			
		}
		return result;
	}	
	
	public void exportXml(String fileName)
	{
		Serializer serializer = new Persister();
		DayDTO example = new DayDTO();
		File result = new File(fileName);

		try {
			serializer.write(example, result);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	//import day data from text file
	public Day importDay(String fileName)
	{
		
		return null;
	}
	
	//import list of days from text file
	public LinkedList<Day> importDays(String fileName)
	{
		
		return null;
	}
}
