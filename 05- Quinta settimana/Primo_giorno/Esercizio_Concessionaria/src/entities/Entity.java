package entities;

public abstract class Entity 
{
	// Proprietà Entity
	
	private int id;
	
	// Costruttore Entity
	
	public Entity(int id) {
		setId(id);
	}
	
	// Getters e setters Entity

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	// To string Entity
	
	public String toString() {
		return "id: " +  id + "\n";
	}
}
