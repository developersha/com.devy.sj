package com.devy.sj.pack;

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
	
	public void addItem(Item item) {
		Items.add(item);
	}

	private boolean isValidateDate(String date) {

		// TODO: date must be in valid format
		
		return true;
	}
	
}
