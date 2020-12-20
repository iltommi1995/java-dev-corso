package com.generation.circo.dao;

import com.generation.utility.database.Database;

public class Config 
{
	// In questa classe si mette il database static
	// Cosi lo può usare tutto il programma
	// Per convenzione le variabili final si scrivono maiuscole
	
	public static final Database DB = new Database("root", "root", "circo");
	
	public static final DAOStaff DS = DAOStaff.getInstance();
	
	public static final DAOClienti DC = DAOClienti.getInstance();
	
	public static final DAOAnimali DA = DAOAnimali.getInstance();
	
	public static final DAOAttrazioni DAT = DAOAttrazioni.getInstance();
}
