package entities;

public class Soldato extends Unita
{
	private String squadra;
	private int potenzaFuoco;
	
	public Soldato(String nome, int x, int y, int maxDistanzaPercorribile, String squadra, int potenzaFuoco)
	{
		super(nome,x,y,maxDistanzaPercorribile);
		setSquadra(squadra);
		setPotenzaFuoco(potenzaFuoco);
	}

	public String getSquadra()
	{
		return squadra;
	}

	public void setSquadra(String squadra)
	{
		this.squadra = squadra;
	}

	public int getPotenzaFuoco()
	{
		return potenzaFuoco;
	}

	public void setPotenzaFuoco(int potenzaFuoco)
	{
		this.potenzaFuoco = potenzaFuoco;
	}
	
	public String toString()
	{
		return super.toString() 										 
								+ "Squadra: "			+ squadra		+ "\n"
								+ "Potenza di fuoco: "	+ potenzaFuoco	+ "\n";
	}
	
	
}