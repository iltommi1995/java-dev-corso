package main;

import java.util.HashMap;
import java.util.Map;

public class Mappe_01 
{
	public static void main(String[] args) 
	{
		// Le mappe sono una coppia chiave valore
		
		Map<String,String> libro;
		
		libro = new HashMap<String, String>();
		
		libro.put("titolo", "Il signore degli anelli");
		
		System.out.println(libro);
		
		System.out.println(libro.keySet() + " " + libro.values());
	}
}
