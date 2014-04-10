package com.devy.sj.pack;

/**
 * Console application to display results
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Manager mgr = new Manager();
    	
    	Item item = new Item();
    	item.id = 1;
    	item.value = args[0];
    	
    	Day day = new Day();
    	day.Items.add(item);
    	mgr.addDay(day);
    	
        System.out.println( "We have " + mgr.Days.size() + " days in SJ." );
        
        System.out.println( "Day1 entry: " + mgr.Days.getFirst().Items.get(0).value );
        
        
    }
}
