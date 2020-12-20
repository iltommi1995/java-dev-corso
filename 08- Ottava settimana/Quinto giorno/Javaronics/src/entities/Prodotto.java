package entities;

public abstract class Prodotto 
{
	private int id;
	
	public Prodotto(int id) {
		setId(id);
	}
	
	public String toString() {
		return "Id: " + id + "\n";
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		if(id > 0)
			this.id = id;
	}
	
	public abstract double prezzo();
}