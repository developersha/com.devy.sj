package com.devy.sj.pack;

import java.util.LinkedList;

public class Manager {
	
	LinkedList<Day> Days;
	
	public Manager()
	{
		Days = new LinkedList<>();		
	}
	
	public void addDay(Day d)
	{		
		Days.add(d);
	}
	
	
}
