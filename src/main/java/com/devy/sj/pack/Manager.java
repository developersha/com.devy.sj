package com.devy.sj.pack;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

import prop.PropertiesWriter;

public class Manager {
	
	LinkedList<Day> Days;
	
	public Manager()
	{
		Days = new LinkedList<Day>();
		
		//TODO: make sure properties file exists
		PropertiesWriter writer = new PropertiesWriter();
		writer.write();
	}
	
	public void addDay(Day d)
	{		
		Days.add(d);		
	}
	
	void addToday()
	{
		//get current date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar cal = Calendar.getInstance();
    	String currentDate = dateFormat.format(cal.getTime());
		
		Day d = new Day();
		d.id = currentDate;
		
		Days.addFirst(d);		
	}
	
	public void addDay(String date)
	{
		if (date == "today")
			addToday();
		else
		{
			Day day = new Day(date);
			Days.add(day);
		}
	}
}
