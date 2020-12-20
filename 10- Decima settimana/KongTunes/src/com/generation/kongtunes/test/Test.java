package com.generation.kongtunes.test;

import com.generation.kongtunes.dao.Config;
import com.generation.kongtunes.dao.DAOAlbum;

public class Test 
{
	public static void main(String[] args) 
	{
		DAOAlbum da = Config.AA;
		
		System.out.println(da.elencoAlbum("inghilterra"));
	}
}
