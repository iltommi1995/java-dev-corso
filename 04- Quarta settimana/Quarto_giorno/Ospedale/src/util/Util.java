package util;

import java.util.ArrayList;

public class Util 
{	
	public static boolean controllaString(String parametro, int minChar , int maxChar) {
		boolean ris = false;
		if (parametro.length() > minChar && parametro.length() < maxChar)
			ris = true;
		return ris;
	}
	
	public static boolean controllaInt(int parametro, int minNum, int maxNum) {
		boolean ris = false;
		if (parametro > minNum && parametro < maxNum)
			ris = true;
		return ris;
	}
	
	public static boolean controllaDouble(double parametro, double minNum, double maxNum) {
		boolean ris = false;
		if (parametro > minNum && parametro < maxNum)
			ris = true;
		return ris;
	}
	
	public static boolean controllaPersona(String nome, String cognome, String dob) {
		int counter = 0;
		
		counter += controllaString(nome, 1, 20) ? 0 : 1;
		counter += controllaString(cognome, 1, 20) ? 0 : 1;
		counter += controllaString(dob, 9, 11) ? 0 : 1;
		
		return counter == 0 ? true : false;
	}
	
	
	public static boolean controllaPaziente(String nome, String cognome, String dob, String patologia, String ricovero) {
		int counter = 0;
		
		counter += controllaPersona(nome, cognome, dob) ? 0 : 1;
		counter += controllaString(patologia, 1, 50) ? 0 : 1;
		counter += (ricovero.equalsIgnoreCase("si") || ricovero.equalsIgnoreCase("no")) ? 0 : 1;
		
		return counter == 0 ? true : false;
	}
	
	// Util.controllaMedico(riga[1], riga[2], riga[3], riga[4], Integer.parseInt(riga[5]), Integer.parseInt(riga[6]))
	
	public static boolean controllaMedico(String nome, String cognome, String dob, String reparto, int nInterventi, int nInterventiOk) {
		int counter = 0;
		
		counter += controllaPersona(nome, cognome, dob) ? 0 : 1;
		counter += controllaString(nome, 1, 20) ? 0 : 1;
		counter += (controllaInt(nInterventi, 0, 1000) && (nInterventi > nInterventiOk) ) ? 0 : 1;
		counter += (controllaInt(nInterventi, 0, 1000) && (nInterventiOk < nInterventi) ) ? 0 : 1;
		
		return counter == 0 ? true : false;
	}
	
	
	// cicla arraylyst
	

}
