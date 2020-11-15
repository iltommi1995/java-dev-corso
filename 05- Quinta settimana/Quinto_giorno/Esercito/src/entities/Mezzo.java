package entities;

public class Mezzo extends Unita
{
	private int carburante;
	private int consumoCarburante;
	private String tipo;
	
	public Mezzo(String nome, int x, int y, int maxDistanzaPercorribile, int carburante,
				 int consumoCarburante, String tipo)
	{
		super(nome,x,y,maxDistanzaPercorribile);
		setCarburante(carburante);
		setConsumoCarburante(consumoCarburante);
		setTipo(tipo);
	}

	public int getCarburante()
	{
		return carburante;
	}

	public void setCarburante(int carburante)
	{
		this.carburante = carburante;
	}

	public int getConsumoCarburante()
	{
		return consumoCarburante;
	}

	public void setConsumoCarburante(int consumoCarburante)
	{
		this.consumoCarburante = consumoCarburante;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	
	public String toString()
	{
		return super.toString() 											
								+ "Carburante: "			+ carburante		+ "\n"
								+ "Consumo di carburante: "	+ consumoCarburante	+ "\n"
								+ "Tipo: "					+ tipo				+ "\n";
	}
	
	public boolean raggiunge(int x, int y)
	{
		boolean ris = false;
		if(super.raggiunge(x, y) == true && (consumoCarburante * super.distanzaDa(x, y)) < carburante)
			ris = true;
		return ris;
	}
	
	public boolean raggiunge(Unita u)
	{
		boolean ris = false;
		if(super.raggiunge(u) == true && (consumoCarburante * super.distanzaDa(u) < carburante))
			ris = true;
		return ris;
	}
}