package test;

import dao.DAODipendenti;
import entities.Dipendente;

public class TestLettura {

	public static void main(String[] args) {
		
		String query = "select * from dipendenti where stipendio > 2000";
		
		DAODipendenti d = new DAODipendenti();
		
		System.out.println(d.mediaStipendi("milano"));
		for(Dipendente dip : d.elenco(query))
				System.out.println(dip.getCognome());
	}
}
