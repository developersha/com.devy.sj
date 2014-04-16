package com.devy.sj.pack;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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
	public void export()
	{
		//create new file
		PrintWriter writer = null;
		try {
			//write file into project root directory
			writer = new PrintWriter("Day.txt", "UTF-8" );			
			writer.println(this.toString());
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		finally
		{
			writer.close();
		}
	}	
}
