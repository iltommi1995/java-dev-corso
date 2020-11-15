package entities;

public class Unita 
{
	// Poprietà Unita

	private String nome;
	private int x;
	private int y;
	private int maxDistanzaPercorribile;

	//Costruttore Unita

	public Unita (String nome,int x,int y,int maxDistanzaPercorribile)
	{
		setNome(nome);
		setX(x);
		setY(y);
		setMaxDistanzaPercorribile(maxDistanzaPercorribile);
	}

	// Getters and setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getMaxDistanzaPercorribile() {
		return maxDistanzaPercorribile;
	}

	public void setMaxDistanzaPercorribile(int maxDistanzaPercorribile) {
		this.maxDistanzaPercorribile = maxDistanzaPercorribile;
	}

	// To String Unita

	public String toString()
	{
		return "Nome: "                      	+ nome                  +  	"\n"  	+
				"X:"                          	+ x                     +  	"\n"  	+
				"Y:"                          	+ y                     + 	"\n"  	+
				"Max distanza percorribile:"  	+ 			maxDistanzaPercorribile + "\n" ;
	}
	// Medoto DistanzaDa(int x, int y)

	public double distanzaDa(int x, int y) 
	{
		double distanza=0;
		distanza= Math.sqrt(Math.pow((x- this.x),2) + Math.pow((y- this.y),2));
		return distanza;
	}

	// Metodo distanzaDa(Unita unita)

	public double distanzaDa(Unita unita)
	{
		double distanzaUnita=0;
		distanzaUnita= ((x-this.x)-(y-this.y));
		return distanzaUnita;
	}

	//Metodo public boolean raggiunge(int x, int y)

	public boolean raggiunge (int x, int y)
	{
		return (maxDistanzaPercorribile >= distanzaDa(x,y) ) ? true : false;
	}
	//	> public boolean raggiunge(Unita u)

	public boolean raggiunge(Unita u)
	{
		int maxDistanzaPercorribile=0;
		boolean ris= false;
		if(maxDistanzaPercorribile >= (x-this.x)-(y-this.y))
			ris=true;
		return ris;
	}
}