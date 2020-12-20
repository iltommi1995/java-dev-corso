package test;

import dao.DAOSede;
import entities.Sede;

public class Test {

	public static void main(String[] args) {
		
		DAOSede daoS = new DAOSede();


		for(Sede s : daoS.elenco("select * from sedi"))
			System.out.println("Nella sede di " + s.getCitta() + " ci sono " + s.getDipendenti().size() + " dipendenti");
	}
	
	
}
