package com.devy.sj.pack;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

public class Manager {
	
	LinkedList<Day> Days;
	
	public Manager()
	{
		Days = new LinkedList<Day>();		
	}
	
	public void addDay(Day d)
	{		
		Days.add(d);		
	}
	
	public void addToday()
	{
		//get current date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar cal = Calendar.getInstance();
    	String currentDate = dateFormat.format(cal.getTime());
		
		Day d = new Day();
		d.id = currentDate;
		
		Days.addFirst(d);		
	}	
}
