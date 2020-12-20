package com.generation.aziendasql3.dao;

import com.generation.utility.database.Database;

public class Config 
{
	// Questa classe servirà a contenere delle proprietà statiche che servono a più 
	// parti del programma. Le creiamo qui una sola volta per evitare di doverle 
	// creare tante volte in giro per il programma. 
	// Basti pensare all'oggetto Database (il ponte): crearlo N volte sarebbe uno spreco 
	// di risorse. Creaiamo una singola copia in questa classe e gli altri lo utilizzeranno
	
	public final static Database DB = new Database("root", "root", "aziendajava2");
	
	public final static DAODipendenti DD = new DAODipendenti();
	
	public final static DAOSedi DS = new DAOSedi();
}
