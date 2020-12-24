package com.generation.aziendasql3.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
	public static void main(String[] args) {
		
		pippo();
		
	}
	
	public static boolean primo(int param)
	{
		int count = 0;
		for(int i = 2; i <= (param/2); i++)
		{
			if(param % i == 0)
				count++;
		}
			
		return count != 0 || param <= 1 ? false : true;
	}
	
	public static List<Integer> listaInt(int... params)
	{
		List<Integer> l = new ArrayList<Integer>();
		for(int i = 0; i < params.length; i++)
			l.add(params[i]);
		return l;
	}
	
	public static void pippo(){
		for(int i = 1; i <= 100; i++)
		{
		if(i%3== 0)
			System.out.println(i + "   hello");
		if(i%5==0)
			System.out.println(i + "   world");
		if(i%3 == 0 & i%5==0)
			System.out.println(i + "   Errore");
		}
	}
}
