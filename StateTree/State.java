/**
 *	The object to store US state information.
 *
 *	@author	
 *	@since	
 */
public class State implements Comparable<State>
{
	private String name;
	private String abbreviation;
	private int population;
	private int area;
	private int reps;
	private String capital;
	private int month;
	private int day;
	private int year;
	
	public State(String n, String a, int p, int ar, int r, String c, int m, int d, int y) 
	{
		name = n;
		abbreviation = a;
		population = p;
		area = a;
		reps = r;
		capital = c;
		month = m;
		day = d;
		year = y;
	}
	
	public int compareTo(State other) 
	{
		return name.compareTo(other.getName());
	}
	
	public String getName ( )
	{
		return name;
	}
	
	public String toString() 
	{
		return String.format("%-20s%-6s%-11d%-11d%-5d%-15s%-3d%-3d%-5d", name, abbreviation, population, area, reps, capital, month, day, year);
	}
}
