package com.devy.sj.pack;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
 
@Root
public class DayDTO
{
    @Element
    public String Date;
 
    @Element
    public String Item;
    
    @Element
    public String DayItems;
    
    public DayDTO()
    {
    	Date="today";
    	Item="item";
    	DayItems="dayItems";    	
    }
}